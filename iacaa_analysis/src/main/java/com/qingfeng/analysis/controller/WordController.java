package com.qingfeng.analysis.controller;

import com.qingfeng.analysis.service.WordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 用于导出Word文档
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/7/14
 */
@RestController
@Api(value = "提供Word文档导出的接口", tags = "Word文档接口")
@RequestMapping("analysis/word")
@CrossOrigin
public class WordController {

    @Autowired
    private WordService wordService;

    @ApiOperation("导出目标达成评价表")
    @GetMapping("export/{courseId}/{year}")
    public void exportWord(@PathVariable("courseId") Integer courseId,
                           @PathVariable("year") Integer year, HttpServletResponse response) throws Exception {
        wordService.exportWord(courseId, year, response);
    }
}
