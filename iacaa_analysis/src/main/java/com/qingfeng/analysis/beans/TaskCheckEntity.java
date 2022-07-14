package com.qingfeng.analysis.beans;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
public class TaskCheckEntity {

    /**
     * 权重系数
     */
    @Excel(name = "权重系数",orderNum = "0",width = 10)
    private Double mix;

    /**
     * 考核环节
     */
    @Excel(name = "考核内容",orderNum = "1",width = 10)
    private String courseTask;
}
