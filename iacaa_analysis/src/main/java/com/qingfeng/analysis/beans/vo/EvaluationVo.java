package com.qingfeng.analysis.beans.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/7/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EvaluationVo {

    /**
     * 达到的人数
     */
    private Integer achieve;
    /**
     * 基本达到
     */
    private Integer mostReach;
    /**
     * 基本达到
     */
    private Integer basicAchieve;
    /**
     * 大部分未达到
     */
    private Integer mostNotAchieve;
    /**
     * 基本未达到
     */
    private Integer basicNotAchieve;
    /**
     * 达成评价值
     */
    private Double evaluationValue;
}
