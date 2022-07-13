package com.qingfeng.analysis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.analysis.beans.CourseTaskEntity;
import com.qingfeng.analysis.beans.TargetEntity;
import com.qingfeng.analysis.beans.vo.CourseTargetVo;
import com.qingfeng.analysis.dao.CourseTaskDao;
import com.qingfeng.analysis.dao.TargetDao;
import com.qingfeng.analysis.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 清风学Java
 */
@Service("targetService")
public class TargetServiceImpl extends ServiceImpl<TargetDao, TargetEntity> implements TargetService {

    @Autowired
    private TargetDao targetDao;
    @Autowired
    private CourseTaskDao courseTaskDao;

    @Override
    public List<CourseTargetVo> findByCourseTargetId(Integer courseId, Integer year) {
        List<CourseTargetVo> courseTargetVoList = targetDao.findByCourseTargetId(courseId, year);


        //将指标点集合返回
        return courseTargetVoList;
    }
}