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
public class AnalysisEvaluationVo {

    /**
     * 名称
     */
    private String name;

    /**
     * 分数数组
     */
    private Integer[] data;
}
