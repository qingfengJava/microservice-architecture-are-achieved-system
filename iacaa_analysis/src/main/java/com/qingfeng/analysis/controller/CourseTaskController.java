package com.qingfeng.analysis.controller;

import com.qingfeng.analysis.service.CourseTaskService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 清风学Java
 * @date 2022-07-12 23:39:45
 */
@RestController
@Api(value = "提供课程目标相关接口", tags = "课程目标模块")
@RequestMapping("analysis/coursetask")
@CrossOrigin
public class CourseTaskController {
    @Autowired
    private CourseTaskService courseTaskService;

}
