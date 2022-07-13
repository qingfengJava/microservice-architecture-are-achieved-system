package com.qingfeng.analysis.controller;

import com.qingfeng.analysis.beans.vo.CourseTargetVo;
import com.qingfeng.analysis.beans.vo.ResultVO;
import com.qingfeng.analysis.constant.ResStatus;
import com.qingfeng.analysis.service.TargetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 清风学Java
 * @date 2022-07-12 23:39:45
 */
@RestController
@Api(value = "提供指标点相关接口", tags = "指标点模块")
@RequestMapping("analysis/target")
@CrossOrigin
public class TargetController {

    @Autowired
    private TargetService targetService;

    @ApiOperation("根据课程Id和年份查询关联指标点信息")
    @GetMapping("findByCourseTargetId/{courseId}/{year}")
    public ResultVO findByCourseTargetId(@PathVariable("courseId") Integer courseId, @PathVariable("year") Integer year) {
        try {
            List<CourseTargetVo> courseTargetVoList = targetService.findByCourseTargetId(courseId, year);
            return new ResultVO(ResStatus.OK,"success",courseTargetVoList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVO(ResStatus.NO,"fail",null);
        }
    }
}
