package com.qingfeng.analysis.beans.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/7/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskVo {

    private String color;
    private String name;
    private double[] data;
}
