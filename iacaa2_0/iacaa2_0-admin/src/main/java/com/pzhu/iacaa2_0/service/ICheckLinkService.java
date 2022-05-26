package com.pzhu.iacaa2_0.service;

import com.pzhu.iacaa2_0.entity.CheckLink;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pzhu.iacaa2_0.entityVo.CheckLinkVo;

import java.util.List;

public interface ICheckLinkService extends IService<CheckLink> {

    List<CheckLink> list(CheckLinkVo vo);

    Boolean summaryByCourseTaskID(Long id, Integer year);

    List<CheckLink> listBySourseTask(Long id);

    void coverNullToZero();
}
