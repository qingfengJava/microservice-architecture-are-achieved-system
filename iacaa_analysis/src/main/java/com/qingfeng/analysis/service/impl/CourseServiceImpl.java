package com.qingfeng.analysis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.analysis.beans.CourseEntity;
import com.qingfeng.analysis.dao.CourseDao;
import com.qingfeng.analysis.service.CourseService;
import org.springframework.stereotype.Service;


@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseDao, CourseEntity> implements CourseService {


}