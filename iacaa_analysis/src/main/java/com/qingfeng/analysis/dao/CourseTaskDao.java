package com.qingfeng.analysis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingfeng.analysis.beans.CourseTaskEntity;
import com.qingfeng.analysis.beans.vo.CourseTaskVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author qingfeng
 * @email ${email}
 * @date 2022-07-12 23:39:47
 */
@Mapper
public interface CourseTaskDao extends BaseMapper<CourseTaskEntity> {

    /**
     * 根据课程Id，指标点id，年份查询课程目标
     * @param courseId
     * @param targetId
     * @param year
     * @return
     */
    public List<CourseTaskVo> findByCourseId(@Param("courseId") Integer courseId,
                                             @Param("targetId") Integer targetId,
                                             @Param("year") Integer year);
}
