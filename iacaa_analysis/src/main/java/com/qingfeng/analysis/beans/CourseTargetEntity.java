package com.qingfeng.analysis.beans;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程指标点实体类
 * 
 * @author 清风学Java
 * @date 2022-07-12 23:39:47
 */
@Data
@TableName("t_course_target")
public class CourseTargetEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	@TableId
	private Integer id;
	/**
	 * 关联课程
	 */
	private Integer courseId;
	/**
	 * 关联指标点
	 */
	private Integer targetId;
	/**
	 * 关联比例
	 */
	private Double mix;
	/**
	 * 创建时间
	 */
	private Date createdDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;

}
