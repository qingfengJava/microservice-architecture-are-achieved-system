package com.qingfeng.analysis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.analysis.beans.CourseTaskEntity;
import com.qingfeng.analysis.dao.CourseTaskDao;
import com.qingfeng.analysis.service.CourseTaskService;
import org.springframework.stereotype.Service;


@Service("courseTaskService")
public class CourseTaskServiceImpl extends ServiceImpl<CourseTaskDao, CourseTaskEntity> implements CourseTaskService {



}