package com.qingfeng.analysis.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ExcelService {

    /**
     * 获取excel分析表格
     *
     * @param response
     */
    void getExcel(HttpServletResponse response, String id, String year) throws IOException;
}
