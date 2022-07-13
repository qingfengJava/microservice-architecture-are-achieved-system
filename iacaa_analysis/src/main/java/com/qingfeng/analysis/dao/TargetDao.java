package com.qingfeng.analysis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingfeng.analysis.beans.TargetEntity;
import com.qingfeng.analysis.beans.vo.CourseTargetVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author qingfeng
 * @email ${email}
 * @date 2022-07-12 23:39:45
 */
@Mapper
public interface TargetDao extends BaseMapper<TargetEntity> {

    /**
     * 根据课程Id查询指标点集合
     * @param courseId
     * @param year
     * @return
     */
    List<CourseTargetVo> findByCourseTargetId(@Param("courseId") Integer courseId,
                                              @Param("year") Integer year);
}
