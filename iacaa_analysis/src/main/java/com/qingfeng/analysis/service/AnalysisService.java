package com.qingfeng.analysis.service;

import com.qingfeng.analysis.beans.vo.ResultVO;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/7/17
 */
public interface AnalysisService {

    /**
     * 学生定量达成情况散点图
     * @param courseId
     * @param year
     * @return
     */
    ResultVO getStuRation(Integer courseId, Integer year);

    /**
     * 学生主观达成情况散点图
     * @param courseId
     * @param year
     * @return
     */
    ResultVO getSubjective(Integer courseId, Integer year);

    /**
     * 课程目标成绩对比
     * @param courseId
     * @param year
     * @return
     */
    ResultVO getCourseTask(Integer courseId, Integer year);
}
