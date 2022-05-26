package com.pzhu.iacaa2_0.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pzhu.iacaa2_0.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_target")
public class Target extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 描述
     */
    @TableField("discribe")
    private String discribe;

    /**
     * 关联毕业要求
     */
    @TableField("req_id")
    private Integer reqId;

    @TableField(exist = false)
    private GradRequirement gradRequirement;

    /**
     * 年份
     */
    @TableField("year")
    private Integer year;

    /**
     * 系统计算成绩
     */
    @TableField("sys_grade")
    private Double sysGrade;

    /**
     * 学生评价成绩
     */
    @TableField("stu_grade")
    private Double stuGrade;



}
