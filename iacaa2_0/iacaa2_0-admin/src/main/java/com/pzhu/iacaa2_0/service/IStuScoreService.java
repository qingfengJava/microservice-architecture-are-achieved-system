package com.pzhu.iacaa2_0.service;

import com.pzhu.iacaa2_0.entity.StuScore;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IStuScoreService extends IService<StuScore> {

    List<StuScore> list(StuScore stuScore);

    Boolean summaryAllCheckLinksScore(Integer year);

    Boolean summaryCheckLinkScoreById(Long id);
}
