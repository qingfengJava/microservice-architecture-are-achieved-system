package com.qingfeng.analysis.controller;

import com.qingfeng.analysis.beans.vo.ResultVO;
import com.qingfeng.analysis.service.StuEvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 清风学Java
 * @date 2022-07-12 23:39:45
 */
@RestController
@Api(value = "提供间接评价相关接口", tags = "间接评价模块")
@RequestMapping("analysis/stuevaluation")
@CrossOrigin
public class StuEvaluationController {

    @Autowired
    private StuEvaluationService stuEvaluationService;

    @ApiOperation("生成学生间接评价数据")
    @GetMapping("/create")
    public ResultVO create(){
        return stuEvaluationService.create();
    }

}
