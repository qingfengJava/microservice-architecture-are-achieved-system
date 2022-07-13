package com.qingfeng.analysis.beans;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程目标实体类
 * 
 * @author 清风学java
 * @date 2022-07-12 23:39:47
 */
@Data
@TableName("t_course_task")
public class CourseTaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	@TableId
	private Integer id;
	/**
	 * 描述
	 */
	private String describes;
	/**
	 * 关联课程
	 */
	private Integer courseId;
	/**
	 * 关联指标点
	 */
	private Integer targetId;
	/**
	 * 占比
	 */
	private Double mix;
	/**
	 * 年份
	 */
	private Integer year;
	/**
	 * 系统录入成绩
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
