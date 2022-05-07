package com.pzhu.iacaa2_0.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pzhu.iacaa2_0.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author 清风学Java
 * @since 2021-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_course_target")
public class CourseTarget extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 关联课程
     */
    @TableField("course_id")
    private Long courseId;


    /**
     * 关联指标点
     */
    @TableField("target_id")
    private Long targetId;

    /**
     * 关联比例
     */
    @TableField("mix")
    private Double mix;



}
