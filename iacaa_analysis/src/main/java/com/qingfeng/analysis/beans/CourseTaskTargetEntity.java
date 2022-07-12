package com.qingfeng.analysis.beans;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author qingfeng
 * @email ${email}
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
