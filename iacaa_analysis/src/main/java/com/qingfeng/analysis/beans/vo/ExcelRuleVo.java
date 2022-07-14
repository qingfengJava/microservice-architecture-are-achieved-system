package com.qingfeng.analysis.beans.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import com.qingfeng.analysis.beans.TaskCheckEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author KK
 * @CreateTime 2022/7/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ExcelRuleVo对象",description = "作为评价规则的vo模型")
public class ExcelRuleVo {

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 第N个目标
     */
    @Excel(name = "序号", groupName = "课程目标",needMerge = true, orderNum = "0", width = 10)
    private String name;

    /**
     * 目标描述
     */
    @Excel(name = "内容", groupName = "课程目标",needMerge = true, orderNum = "1", width = 100)
    private String desc;

    /**
     * 对应的毕业要求
     */
    @Excel(name = "对应毕业要求",needMerge = true, orderNum = "2", width = 50)
    private String graduation;

    /**
     * 考核环节的权重
     */
    @ExcelCollection(name = "考核环节",orderNum = "3")
    private ArrayList<TaskCheckEntity> tasks;
}
