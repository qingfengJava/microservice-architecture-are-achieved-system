package com.qingfeng.analysis.beans;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 毕业要求实体类
 * 
 * @author 清风学Java
 * @date 2022-07-12 23:39:47
 */
@Data
@TableName("t_grad_requirement")
public class GradRequirementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	@TableId
	private Integer id;
	/**
	 * 毕业要求
	 */
	private String name;
	/**
	 * 描述
	 */
	private String discrible;
	/**
	 * 年份
	 */
	private Integer year;
	/**
	 * 系统计算成绩
	 */
	private Double sysGrade;
	/**
	 * 学生评价成绩
	 */
	private Double stuGrade;
	/**
	 * 创建时间
	 */
	private Date createdDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;

}
