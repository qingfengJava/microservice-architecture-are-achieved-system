package com.pzhu.iacaa2_0.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pzhu.iacaa2_0.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_course")
public class Course extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 内容
     */
    @TableField("name")
    private String name;

    /**
     * 图片地址
     */
    @TableField("image")
    private String image;

    /**
     * 管理账户
     */
    @TableField("edit_user_id")
    private Integer editUserId;


    /**
     * 课程编辑状态
     */
    @TableField("edit_status")
    private Integer editStatus;

}
