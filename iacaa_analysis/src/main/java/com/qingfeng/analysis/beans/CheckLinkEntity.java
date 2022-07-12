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
@TableName("t_check_link")
public class CheckLinkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	@TableId
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
	 * 创建时间
	 */
	private Date createdDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;

}
