package com.pzhu.iacaa2_0.mapper;

import com.pzhu.iacaa2_0.entity.CourseTarget;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pzhu.iacaa2_0.entityVo.CourseTargetVo;

import java.util.List;


public interface CourseTargetMapper extends BaseMapper<CourseTarget> {
    List<CourseTargetVo> volist(CourseTargetVo vo);

    Integer removeByTargetId(Long id);
}
