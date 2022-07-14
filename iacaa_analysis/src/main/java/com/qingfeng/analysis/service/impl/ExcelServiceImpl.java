package com.qingfeng.analysis.service.impl;

import com.qingfeng.analysis.beans.vo.ExcelRuleVo;
import com.qingfeng.analysis.dao.ExcelDao;
import com.qingfeng.analysis.service.ExcelService;
import com.qingfeng.analysis.util.EasyPoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author KK
 * @CreateTime 2022/7/14
 */
@Service("excelService")
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private ExcelDao dao;

    @Override
    public void getExcel(HttpServletResponse response, String id, String year) throws IOException {
        List<ExcelRuleVo> rules = dao.getRule(id, year);
        String courseName = rules.get(0).getCourseName();
        EasyPoiUtils.exportExcelByRule(rules, courseName + "评分细则", "评分细则", ExcelRuleVo.class, courseName + ".xlsx", response);
    }
}
