package com.qingfeng.analysis.controller;

import com.qingfeng.analysis.beans.vo.ResultVO;
import com.qingfeng.analysis.dao.ExcelDao;
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

    @Autowired
    private ExcelDao excelDao;

    @ApiOperation("获取excel表格")
    @GetMapping("/down/{id}/{year}")
    public void getExcel(HttpServletResponse response, @PathVariable String id, @PathVariable String year) throws IOException {
        excelService.getExcel(response,id,year);
    }

    @ApiOperation("获取评价细则表格数据")
    @GetMapping("/e/{id}/{year}")
    public ResultVO getExcelObj(@PathVariable String id, @PathVariable String year) throws IOException {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(excelDao.getRule(id,year));
        return resultVO;
    }

    @ApiOperation("获取成绩表格数据")
    @GetMapping("/stu/{id}/{year}")
    public ResultVO getExcelStuObj(@PathVariable String id, @PathVariable String year) throws IOException {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(excelService.getStu(id,year));
        return resultVO;
    }
}
