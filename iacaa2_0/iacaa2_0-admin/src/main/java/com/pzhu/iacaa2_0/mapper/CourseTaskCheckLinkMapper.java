package com.pzhu.iacaa2_0.mapper;

import com.pzhu.iacaa2_0.entity.CourseTaskCheckLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pzhu.iacaa2_0.entityVo.CourseTaskCheckLinkVo;

import java.util.List;


public interface CourseTaskCheckLinkMapper extends BaseMapper<CourseTaskCheckLink> {

    List<CourseTaskCheckLinkVo> voList(CourseTaskCheckLinkVo vo);
}
