package com.qingfeng.analysis.controller;

import com.qingfeng.analysis.service.CourseTaskCheckLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 清风学Java
 * @date 2022-07-12 23:39:45
 */
@RestController
@RequestMapping("analysis/coursetaskchecklink")
public class CourseTaskCheckLinkController {
    @Autowired
    private CourseTaskCheckLinkService courseTaskCheckLinkService;


}
