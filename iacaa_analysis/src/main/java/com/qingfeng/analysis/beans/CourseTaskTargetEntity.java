package com.qingfeng.analysis.beans;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程目标-指标点实体类
 * 
 * @author 清风学Java
 * @date 2022-07-12 23:39:47
 */
@Data
@TableName("t_course_task_target")
public class CourseTaskTargetEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long targetId;
	/**
	 * 
	 */
	private Long courseTaskId;
	/**
	 * 
	 */
	private Double mix;
	/**
	 * 
	 */
	private Date createdDate;
	/**
	 * 
	 */
	private Date updateDate;

}
