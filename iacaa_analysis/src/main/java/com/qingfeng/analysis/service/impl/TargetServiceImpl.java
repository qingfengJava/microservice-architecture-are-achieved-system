package com.qingfeng.analysis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.analysis.beans.StuEvaluationEntity;
import com.qingfeng.analysis.beans.TargetEntity;
import com.qingfeng.analysis.beans.vo.CourseTargetVo;
import com.qingfeng.analysis.beans.vo.CourseTaskVo;
import com.qingfeng.analysis.beans.vo.EvaluationVo;
import com.qingfeng.analysis.dao.StuEvaluationDao;
import com.qingfeng.analysis.dao.TargetDao;
import com.qingfeng.analysis.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;


/**
 * @author 清风学Java
 */
@Service("targetService")
public class TargetServiceImpl extends ServiceImpl<TargetDao, TargetEntity> implements TargetService {

    @Autowired
    private TargetDao targetDao;
    @Autowired
    private StuEvaluationDao evaluationDao;

    @Override
    public List<CourseTargetVo> findByCourseTargetId(Integer courseId, Integer year) {
        List<CourseTargetVo> courseTargetVoList = targetDao.findByCourseTargetId(courseId, year);
        //遍历查询学生间接达成评价的结果
        for (CourseTargetVo courseTargetVo : courseTargetVoList) {
            QueryWrapper<StuEvaluationEntity> wrapper = null;
            for (CourseTaskVo courseTaskVo : courseTargetVo.getCourseTaskVoList()) {
                //根据Id查询不同分值段的人数
                //查询分值为5的人数
                wrapper = new QueryWrapper<>();
                wrapper.eq("course_task",courseTaskVo.getId());
                wrapper.eq("score",5.000);
                Integer achieve = evaluationDao.selectCount(wrapper);
                //查询分值为4的人数
                wrapper = new QueryWrapper<>();
                wrapper.eq("course_task",courseTaskVo.getId());
                wrapper.eq("score",4.000);
                Integer mostReach = evaluationDao.selectCount(wrapper);
                //查询分值为3的人数
                wrapper = new QueryWrapper<>();
                wrapper.eq("course_task",courseTaskVo.getId());
                wrapper.eq("score",3.000);
                Integer basicAchieve = evaluationDao.selectCount(wrapper);
                //查询分值为2的人数
                wrapper = new QueryWrapper<>();
                wrapper.eq("course_task",courseTaskVo.getId());
                wrapper.eq("score",2.000);
                Integer mostNotAchieve = evaluationDao.selectCount(wrapper);
                //查询分值为1的人数
                wrapper = new QueryWrapper<>();
                wrapper.eq("course_task",courseTaskVo.getId());
                wrapper.eq("score",1.000);
                Integer basicNotAchieve = evaluationDao.selectCount(wrapper);

                //封装数据
                EvaluationVo evaluationVo = new EvaluationVo();
                evaluationVo.setAchieve(achieve);
                evaluationVo.setMostReach(mostReach);
                evaluationVo.setBasicAchieve(basicAchieve);
                evaluationVo.setMostNotAchieve(mostNotAchieve);
                evaluationVo.setBasicNotAchieve(basicNotAchieve);
                evaluationVo.setEvaluationValue(Double.parseDouble(new DecimalFormat("#.00").format(((double) (achieve*5 + mostReach*4 + basicAchieve*3+mostNotAchieve*2+basicNotAchieve+1)) / (75*5))));

                courseTaskVo.setEvaluationVo(evaluationVo);
            }
        }

        //将指标点集合返回
        return courseTargetVoList;
    }
}