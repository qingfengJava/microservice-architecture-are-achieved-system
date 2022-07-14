package com.qingfeng.analysis.controller;

import com.qingfeng.analysis.service.ExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author KK
 * @CreateTime 2022/7/14
 */
@RestController
@Api(value = "excel表格", tags = "excel表格")
@RequestMapping("analysis/excel")
@CrossOrigin
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @ApiOperation("获取excel表格")
    @GetMapping("/{id}")
    public void getExcel(HttpServletResponse response, @PathVariable String id) throws IOException {
        excelService.getExcel(response,id);
    }
}
