package com.pzhu.iacaa2_0.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pzhu.iacaa2_0.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_stu_score")
public class StuScore extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("check_link_id")
    private Integer checkLinkId;

    @TableField("stuno")
    private String stuno;

    @TableField("score")
    private Double score;

    @TableField("created_date")
    private LocalDateTime createdDate;

    @TableField("update_date")
    private LocalDateTime updateDate;

    @TableField("mix_score")
    private Double mixScore;


}
