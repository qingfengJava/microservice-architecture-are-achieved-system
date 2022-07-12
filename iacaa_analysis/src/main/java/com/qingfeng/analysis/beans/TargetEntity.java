package com.qingfeng.analysis.beans;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author qingfeng
 * @email ${email}
 * @date 2022-07-12 23:39:45
 */
@Data
@TableName("t_target")
public class TargetEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	@TableId
	private Integer id;
	/**
	 * 描述
	 */
	private String discribe;
	/**
	 * 关联毕业要求
	 */
	private Integer reqId;
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
