package com.qingfeng.analysis.controller;

import com.qingfeng.analysis.beans.vo.ResultVO;
import com.qingfeng.analysis.service.AnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/7/17
 */
@RestController
@Api(value = "提供课程目标达成评价分析的相关接口", tags = "课程目标达成评价分析")
@RequestMapping("analysis")
@CrossOrigin
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @ApiOperation("学生定量达成情况散点图")
    @GetMapping("/ration/{courseId}/{year}")
    public ResultVO getStuRation(@PathVariable("courseId") Integer courseId, @PathVariable("year") Integer year){
        return analysisService.getStuRation(courseId, year);
    }

    @ApiOperation("学生主观达成情况散点图")
    @GetMapping("/subjective/{courseId}/{year}")
    public ResultVO getSubjective(@PathVariable("courseId") Integer courseId, @PathVariable("year") Integer year){
        return analysisService.getSubjective(courseId,year);
    }

    @ApiOperation("目标成绩对比数据")
    @GetMapping("/task/{courseId}/{year}")
    public ResultVO getCourseTask(@PathVariable("courseId") Integer courseId, @PathVariable("year") Integer year){
        return analysisService.getCourseTask(courseId,year);
    }
}
