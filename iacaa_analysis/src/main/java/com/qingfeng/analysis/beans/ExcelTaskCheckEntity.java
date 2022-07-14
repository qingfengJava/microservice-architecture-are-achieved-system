package com.qingfeng.analysis.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KK
 * @CreateTime 2022/7/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelTaskCheckEntity {

    /**
     * 考核环节名称
     */
    private String taskName;

    /**
     * 该学生的考核环节成绩
     */
    private Double score;

    /**
     * 考核环节达成度
     */
    private Double reach;

    /**
     * 该考核环节的权重系数
     */
    private Double mix;
}
