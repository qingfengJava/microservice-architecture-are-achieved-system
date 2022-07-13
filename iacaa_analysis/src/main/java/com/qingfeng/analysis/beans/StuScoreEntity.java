package com.qingfeng.analysis.beans;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生成绩实体类
 * 
 * @author 清风学Java
 * @date 2022-07-12 23:39:46
 */
@Data
@TableName("t_stu_score")
public class StuScoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Integer checkLinkId;
	/**
	 * 
	 */
	private String stuno;
	/**
	 * 
	 */
	private Double score;
	/**
	 * 
	 */
	private Date createdDate;
	/**
	 * 
	 */
	private Date updateDate;
	/**
	 * 
	 */
	private Double mixScore;

}
