package com.qingfeng.analysis.service;

import com.qingfeng.analysis.beans.vo.ResultVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    ResultVO getStu(String id, String year);
}
