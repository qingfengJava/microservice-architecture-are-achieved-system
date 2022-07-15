package com.qingfeng.analysis.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.analysis.beans.CourseTaskEntity;
import com.qingfeng.analysis.beans.StuEvaluationEntity;
import com.qingfeng.analysis.beans.vo.ResultVO;
import com.qingfeng.analysis.constant.ResStatus;
import com.qingfeng.analysis.dao.StuEvaluationDao;
import com.qingfeng.analysis.service.CourseTaskService;
import com.qingfeng.analysis.service.StuEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author 清风学Java
 */
@Service("stuEvaluationService")
public class StuEvaluationServiceImpl extends ServiceImpl<StuEvaluationDao, StuEvaluationEntity> implements StuEvaluationService {

    @Autowired
    private CourseTaskService courseTaskService;

    @Override
    public ResultVO create() {
        //查询所有的课程目标集合
        List<CourseTaskEntity> courseTaskList = courseTaskService.list(null);
        //遍历每一个课程目标，为其添加间接评价成绩
        for (CourseTaskEntity courseTaskEntity : courseTaskList) {
            for (int i = 1; i <= 75 ; i++) {
                //每一次循环创建一个对象
                StuEvaluationEntity stuEvaluationEntity = new StuEvaluationEntity();
                stuEvaluationEntity.setCourseTask(Long.parseLong(courseTaskEntity.getId()+""));
                stuEvaluationEntity.setIp("10.54.30.23");
                stuEvaluationEntity.setStuNo("2019108010"+(i < 10 ? "0"+i : i ));
                stuEvaluationEntity.setCreatedDate(new Date());
                stuEvaluationEntity.setUpdateDate(new Date());
                stuEvaluationEntity.setScore((double) RandomUtil.randomInt(2,6));

                //baseMapper.insert(stuEvaluationEntity);
            }
        }

        return new ResultVO(ResStatus.OK,"success", null);
    }

}