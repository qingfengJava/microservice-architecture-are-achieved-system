package com.qingfeng.analysis.controller;

import com.qingfeng.analysis.service.CourseTaskCheckLinkService;
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
@Api(value = "提供课程目标-考核环节相关接口", tags = "课程目标-考核环节模块")
@RequestMapping("analysis/coursetaskchecklink")
@CrossOrigin
public class CourseTaskCheckLinkController {
    @Autowired
    private CourseTaskCheckLinkService courseTaskCheckLinkService;


}
