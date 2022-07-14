package com.qingfeng.analysis.beans.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 考核环节实体类
 * 
 * @author 清风学Java
 * @date 2022-07-12 23:39:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CheckLinkVo implements Serializable {

	/**
	 * 唯一标识
	 */
	private Integer id;
	/**
	 * 所属课程
	 */
	private Integer courseId;
	/**
	 * 标题
	 */
	private String name;
	/**
	 * 目标成绩
	 */
	private Double targetScore;
	/**
	 * 平均成绩
	 */
	private Double averageScore;
	/**
	 * 年份
	 */
	private Integer year;

	/**
	 * 课程目标考核环节占比
	 */
	private Double mix;

}
