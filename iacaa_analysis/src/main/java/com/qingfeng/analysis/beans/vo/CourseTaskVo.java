package com.qingfeng.analysis.beans.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/7/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseTaskVo {


    /**
     * 唯一标识
     */
    private Integer id;
    /**
     * 描述
     */
    private String describes;
    /**
     * 关联课程
     */
    private Integer courseId;
    /**
     * 关联指标点
     */
    private Integer targetId;
    /**
     * 占比
     */
    private Double mix;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 系统录入成绩
     */
    private Double sysGrade;
    /**
     * 学生评价成绩
     */
    private Double stuGrade;

    /**
     * 关联考核环节
     */
    private List<CheckLinkVo> checkLinkVoList;
}
