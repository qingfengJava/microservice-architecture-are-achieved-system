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
 * @date 2022-07-12 23:39:47
 */
@Data
@TableName("t_course")
public class CourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	@TableId
	private Integer id;
	/**
	 * 内容
	 */
	private String name;
	/**
	 * 图片地址
	 */
	private String image;
	/**
	 * 管理账户
	 */
	private Long editUserId;
	/**
	 * 课程编辑状态
	 */
	private Integer editStatus;
	/**
	 * 创建时间
	 */
	private Date createdDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;

}
