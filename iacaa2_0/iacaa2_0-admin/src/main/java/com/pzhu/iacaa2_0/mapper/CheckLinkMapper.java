package com.pzhu.iacaa2_0.mapper;

import com.pzhu.iacaa2_0.entity.CheckLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pzhu.iacaa2_0.entityVo.CheckLinkVo;

import java.util.List;

public interface CheckLinkMapper extends BaseMapper<CheckLink> {

    List<CheckLink> list(CheckLinkVo vo);

    List<CheckLink> listByCourseTaskId(String id);

    Integer summaryByCourseTaskId(Long id);

    List<CheckLink> listBySourseTask(Long id);

    List<CheckLink> getByCourseId(Long id);

    Integer coverNullToZero();
}
