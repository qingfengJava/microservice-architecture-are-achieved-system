package com.qingfeng.analysis.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/7/14
 */
public interface WordService {

    /**
     * 导出目标达成评价表
     * @param courseId
     * @param year
     * @param response
     */
    void exportWord(Integer courseId, Integer year, HttpServletResponse response) throws Exception;
}
