package com.pzhu.iacaa2_0.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pzhu.iacaa2_0.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_course_task_evaluate")
public class CourseTaskEvaluate extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * ip
     */
    @TableField("ip_adress")
    private String ipAdress;

    /**
     * 评价课程目标
     */
    @TableField("task_id")
    private Integer taskId;

    /**
     * 分数（1~5分）
     */
    @TableField("grade")
    private Integer grade;

    /**
     * 年份
     */
    @TableField("year")
    private LocalDateTime year;



}
