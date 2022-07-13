package com.qingfeng.analysis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingfeng.analysis.beans.CourseEntity;
import com.qingfeng.analysis.beans.vo.ResultVO;
import com.qingfeng.analysis.constant.ResStatus;
import com.qingfeng.analysis.service.CourseService;
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
@Api(value = "提供课程相关接口", tags = "课程模块")
@RequestMapping("analysis/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation("查询所有课程")
    @GetMapping("/findAll")
    public ResultVO findAll(){
        List<CourseEntity> courseEntityList = courseService.findAll();
        if (courseEntityList != null){
            return new ResultVO(ResStatus.OK,"success",courseEntityList);
        }else{
            return new ResultVO(ResStatus.NO,"fail", null);
        }
    }

    @ApiOperation("根据课程Id查询课程信息")
    @GetMapping("findByCourseId/{courseId}")
    public ResultVO findByCourseId(@PathVariable("courseId") Integer courseId){
        QueryWrapper<CourseEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("id",courseId);
        CourseEntity courseEntity = courseService.getOne(wrapper);
        return new ResultVO(ResStatus.OK,"success",courseEntity);
    }
}
