package com.qingfeng.analysis.beans.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.qingfeng.analysis.beans.ExcelStuEntity;
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
public class ExcelStuVo {

    /**
     * 学号
     */
    private String uid;

    /**
     * 总分
     */
    @TableField(exist = false)
    private Double scoreAll;

    /**
     * 课程目标
     */
    private ArrayList<ExcelStuEntity> tak;
}
