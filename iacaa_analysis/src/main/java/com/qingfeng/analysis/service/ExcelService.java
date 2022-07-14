package com.qingfeng.analysis.service;

import com.qingfeng.analysis.beans.vo.ExcelStuVo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ExcelService {

    /**
     * 获取excel分析表格
     *
     * @param response
     */
    void getExcel(HttpServletResponse response, String id, String year) throws IOException;

    /**
     * 获取成绩表格数据
     * @param id
     * @param year
     * @return
     */
    List<ExcelStuVo> getStu(String id, String year);
}
