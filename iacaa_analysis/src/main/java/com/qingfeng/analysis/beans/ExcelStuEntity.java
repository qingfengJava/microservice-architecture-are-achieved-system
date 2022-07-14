package com.qingfeng.analysis.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author KK
 * @CreateTime 2022/7/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelStuEntity {

    /**
     * 课程目标名称
     */
    private String name;

    /**
     * 目标得分
     */
    @TableField(exist = false)
    private Double scoreTar;

    /**
     * 目标达成度
     */
    @TableField(exist = false)
    private Double reachTar;

    /**
     * 课程目标对应的考核环节
     */
    private ArrayList<ExcelTaskCheckEntity> tasks;
}
