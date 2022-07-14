package com.qingfeng.analysis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingfeng.analysis.beans.CheckLinkEntity;
import com.qingfeng.analysis.beans.vo.CheckLinkVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author 清风学Java
 * @date 2022-07-12 23:39:47
 */
@Mapper
public interface CheckLinkDao extends BaseMapper<CheckLinkEntity> {

    /**
     * 查询课程目标-考核环节
     * 课程目标Id   课程id   年份
     * @param courseTaskId
     * @param courseId
     * @param year
     * @return
     */
    List<CheckLinkVo> findCheckLinkList(@Param("courseTaskId") Integer courseTaskId,
                                        @Param("courseId") Integer courseId,
                                        @Param("year") Integer year);
}
