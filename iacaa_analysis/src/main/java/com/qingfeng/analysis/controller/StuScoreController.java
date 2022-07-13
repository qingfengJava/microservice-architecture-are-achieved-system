package com.qingfeng.analysis.controller;

import com.qingfeng.analysis.service.StuScoreService;
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
@Api(value = "提供学生成绩相关接口", tags = "学生成绩模块")
@RequestMapping("analysis/stuscore")
@CrossOrigin
public class StuScoreController {
    @Autowired
    private StuScoreService stuScoreService;

}
