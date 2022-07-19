package com.qingfeng.analysis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingfeng.analysis.beans.CourseTaskEntity;
import com.qingfeng.analysis.beans.StuEvaluationEntity;
import com.qingfeng.analysis.beans.StuScoreEntity;
import com.qingfeng.analysis.beans.vo.*;
import com.qingfeng.analysis.constant.ResStatus;
import com.qingfeng.analysis.dao.CourseTaskDao;
import com.qingfeng.analysis.dao.StuEvaluationDao;
import com.qingfeng.analysis.dao.StuScoreDao;
import com.qingfeng.analysis.dao.TargetDao;
import com.qingfeng.analysis.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/7/17
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private TargetDao targetDao;
    @Autowired
    private StuScoreDao stuScoreDao;
    @Autowired
    private CourseTaskDao courseTaskDao;
    @Autowired
    private StuEvaluationDao stuEvaluationDao;

    /**
     * 学生定量达成情况散点图
     * @param courseId
     * @param year
     * @return
     */
    @Override
    public ResultVO getStuRation(Integer courseId, Integer year) {
        List<CourseTargetVo> courseTarget = targetDao.findByCourseTargetId(courseId, year);
        //先拿到每个目标的集合
        HashMap<Integer, List<CheckLinkVo>> map = new HashMap<>(16);
        for (CourseTargetVo courseTargetVo : courseTarget) {
            for (CourseTaskVo courseTaskVo : courseTargetVo.getCourseTaskVoList()) {
                map.put(Integer.parseInt(courseTaskVo.getDescribes().substring(2,3)),courseTaskVo.getCheckLinkVoList());
            }
        }
        //每个map表示一个目标，每个目标下有不同的考核环节，需要根据考核环节查询课程成绩
        List<AnalysisScoreVo> params = new ArrayList<>();
        HashMap<String, Object> averageValue = new HashMap<>(16);
        int totalNum = 0;
        for (Map.Entry<Integer, List<CheckLinkVo>> entry : map.entrySet()) {
            List<CheckLinkVo> checkLinkList = entry.getValue();
            //每一个list下面有考核环节，然后查询成绩
            //使用一个map来存储查询到的成绩，然后再计算
            Map<Integer, Double> scoreMap = new HashMap<>(16);
            Map<Integer, Integer> evaluationMap = new HashMap<>(16);
            evaluationMap.put(1,0);
            evaluationMap.put(2,0);
            evaluationMap.put(3,0);
            evaluationMap.put(4,0);
            evaluationMap.put(5,0);

            for (CheckLinkVo checkLinkVo : checkLinkList) {
                int count = 1;
                QueryWrapper<StuScoreEntity> queryWrapper = new QueryWrapper();
                queryWrapper.eq("check_link_id",checkLinkVo.getId());
                queryWrapper.orderByAsc("stuno");
                List<StuScoreEntity> list = stuScoreDao.selectList(queryWrapper);
                totalNum = list.size();
                //计算成绩
                for (StuScoreEntity stuScoreEntity : list) {
                    Double score = 0.0;
                    if(scoreMap.get(count) == null){
                        score = stuScoreEntity.getScore()/checkLinkList.size();
                    }else{
                        score = scoreMap.get(count) + stuScoreEntity.getScore()/checkLinkList.size();
                    }

                    //同时处理成绩结果数据
                    if (score >= 90){
                        evaluationMap.put(1,evaluationMap.get(1)+1);
                    }else if (score >= 80){
                        evaluationMap.put(2,evaluationMap.get(2)+1);
                    }else if (score >= 70){
                        evaluationMap.put(3,evaluationMap.get(3)+1);
                    }else if (score >= 60){
                        evaluationMap.put(4,evaluationMap.get(4)+1);
                    }else{
                        evaluationMap.put(5,evaluationMap.get(4)+1);
                    }

                    scoreMap.put(count,score);
                    count++;
                }
            }

            //计算完成绩，将成绩转换为数组集合，存储到params中
            int[][] scoreArr = new int[totalNum][2];
            Double totalScore = 0.0;
            for (int i = 0; i < scoreArr.length; i++) {
                scoreArr[i][0] = i+1;
                scoreArr[i][1] = Integer.parseInt(String.valueOf(scoreMap.get(i+1)).substring(0,2));
                totalScore += scoreMap.get(i+1) / scoreArr.length;
            }

            //创建对象封装数据
            AnalysisScoreVo analysisScoreVo = new AnalysisScoreVo();
            analysisScoreVo.setName("目标"+entry.getKey());
            analysisScoreVo.setScoreArr(scoreArr);
            analysisScoreVo.setAverageScore(Double.parseDouble(new DecimalFormat("#.00").format(totalScore)));
            analysisScoreVo.setStr1(evaluationMap.get(1)*2 + "%");
            analysisScoreVo.setStr2(evaluationMap.get(2)*2 + "%");
            analysisScoreVo.setStr3(evaluationMap.get(3)*2 + "%");
            analysisScoreVo.setStr4(evaluationMap.get(4)*2 + "%");
            analysisScoreVo.setStr5(evaluationMap.get(5)*2 + "%");
            params.add(analysisScoreVo);
        }

        return new ResultVO(ResStatus.OK,"success",params);
    }

    /**
     * 学生主观达成情况散点图
     * @param courseId
     * @param year
     * @return
     */
    @Override
    public ResultVO getSubjective(Integer courseId, Integer year) {
        try {
            //先根据课程id和年份查询课程目标
            QueryWrapper<CourseTaskEntity> courseTaskEntityQueryWrapper = new QueryWrapper<>();
            courseTaskEntityQueryWrapper.eq("course_id",courseId);
            courseTaskEntityQueryWrapper.eq("year",year);
            List<CourseTaskEntity> taskEntityList = courseTaskDao.selectList(courseTaskEntityQueryWrapper);

            List<AnalysisEvaluationVo> list = new ArrayList<>();
            //遍历课程目标，查询每个课程目标下的成绩
            QueryWrapper<StuEvaluationEntity> wrapper = null;
            for (CourseTaskEntity courseTaskEntity : taskEntityList) {

                //根据Id查询不同分值段的人数
                //查询分值为5的人数
                wrapper = new QueryWrapper<>();
                wrapper.eq("course_task",courseTaskEntity.getId());
                wrapper.eq("score",5.000);
                Integer achieve = stuEvaluationDao.selectCount(wrapper);
                //查询分值为4的人数
                wrapper = new QueryWrapper<>();
                wrapper.eq("course_task",courseTaskEntity.getId());
                wrapper.eq("score",4.000);
                Integer mostReach = stuEvaluationDao.selectCount(wrapper);
                //查询分值为3的人数
                wrapper = new QueryWrapper<>();
                wrapper.eq("course_task",courseTaskEntity.getId());
                wrapper.eq("score",3.000);
                Integer basicAchieve = stuEvaluationDao.selectCount(wrapper);
                //查询分值为2的人数
                wrapper = new QueryWrapper<>();
                wrapper.eq("course_task",courseTaskEntity.getId());
                wrapper.eq("score",2.000);
                Integer mostNotAchieve = stuEvaluationDao.selectCount(wrapper);
                //查询分值为1的人数
                wrapper = new QueryWrapper<>();
                wrapper.eq("course_task",courseTaskEntity.getId());
                wrapper.eq("score",1.000);
                Integer basicNotAchieve = stuEvaluationDao.selectCount(wrapper);

                //遍历集合， 封装数据
                Integer[] scoreArr = new Integer[]{achieve,mostReach,basicAchieve,mostNotAchieve,basicNotAchieve};

                //将数据封装到对象中

                list.add(new AnalysisEvaluationVo(courseTaskEntity.getDescribes().substring(0,3),scoreArr));
            }

            return new ResultVO(ResStatus.OK,"success",list);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new ResultVO(ResStatus.NO,"fail", null);
        }
    }

    /**
     * 获取课程目标成绩对比数据
     * @param courseId
     * @param year
     * @return
     */
    @Override
    public ResultVO getCourseTask(Integer courseId, Integer year) {
        //根据课程id和年份查询课程目标
        QueryWrapper<CourseTaskEntity> courseTaskEntityQueryWrapper = new QueryWrapper<>();
        courseTaskEntityQueryWrapper.eq("course_id",courseId);
        courseTaskEntityQueryWrapper.eq("year",year);
        List<CourseTaskEntity> taskEntityList = courseTaskDao.selectList(courseTaskEntityQueryWrapper);

        //循环遍历存储数据
        String[] name = new String[taskEntityList.size()];
        double[] rationScore = new double[taskEntityList.size()];
        double[] subjectiveScore = new double[taskEntityList.size()];
        int count = 0;
        double ration = 0.0;
        double subjective = 0.0;
        for (CourseTaskEntity courseTaskEntity : taskEntityList) {
            name[count] = courseTaskEntity.getDescribes();
            rationScore[count] = courseTaskEntity.getSysGrade()*100;
            subjectiveScore[count] = courseTaskEntity.getStuGrade()*100;
            ration += courseTaskEntity.getSysGrade()*100 / taskEntityList.size();
            subjective += courseTaskEntity.getStuGrade()*100 / taskEntityList.size();
            count++;
        }

        AnalysisTaskVo analysisTaskVo = new AnalysisTaskVo();
        analysisTaskVo.setName(name);
        List<TaskVo> taskList = new ArrayList<>();
        taskList.add(new TaskVo("red","定量达成值",rationScore));
        taskList.add(new TaskVo("blue","主观达成值",subjectiveScore));
        analysisTaskVo.setTask(taskList);
        analysisTaskVo.setRationScore(Double.parseDouble(new DecimalFormat("#.00").format(ration)));
        analysisTaskVo.setSubjectiveScore(Double.parseDouble(new DecimalFormat("#.00").format(subjective)));

        return new ResultVO(ResStatus.OK, "success", analysisTaskVo);
    }
}
