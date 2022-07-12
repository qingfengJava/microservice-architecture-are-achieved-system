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
@TableName("t_course_task_check_link")
public class CourseTaskCheckLinkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	@TableId
	private Long id;
	/**
	 * 课程目标
	 */
	private Integer courseTaskId;
	/**
	 * 考核环节
	 */
	private Integer checkLinkId;
	/**
	 * 支撑权重
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
