package com.qingfeng.analysis.beans.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/7/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnalysisScoreVo {

    /**
     * 目标名称
     */
    private String name;
    /**
     * 平均成绩
     */
    private Double averageScore;
    /**
     * 分数数组
     */
    private int[][] scoreArr;

    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;

}
