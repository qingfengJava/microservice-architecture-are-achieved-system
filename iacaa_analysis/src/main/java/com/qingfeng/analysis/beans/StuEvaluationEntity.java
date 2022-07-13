package com.qingfeng.analysis.beans;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生间接评价实体类
 * 
 * @author 清风学Java
 * @date 2022-07-12 23:39:46
 */
@Data
@TableName("t_stu_evaluation")
public class StuEvaluationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Long courseTask;
	/**
	 * 
	 */
	private String ip;
	/**
	 * 
	 */
	private String stuNo;
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

}
