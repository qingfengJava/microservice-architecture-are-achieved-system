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
public class CourseTargetVo {

    /**
     * 指标点id
     */
    private Integer id;
    /**
     * 课程Id
     */
    private Integer courseId;
    /**
     * 描述
     */
    private String discribe;
    /**
     * 关联毕业要求
     */
    private Integer reqId;

    /**
     * 指标点-课程目标关联比例
     */
    private Double mix;

    /**
     * 年份
     */
    private Integer year;
    /**
     * 系统计算成绩
     */
    private Double sysGrade;
    /**
     * 学生评价成绩
     */
    private Double stuGrade;

    /**
     * 课程目标
     */
    private List<CourseTaskVo> courseTaskVoList;
}
