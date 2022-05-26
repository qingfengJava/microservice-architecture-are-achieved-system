package com.pzhu.iacaa2_0.service;

import com.pzhu.iacaa2_0.entity.StuEvaluation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pzhu.iacaa2_0.entityVo.StuEvaluationStatisticsVo;

import java.util.List;


public interface IStuEvaluationService extends IService<StuEvaluation> {

    List<StuEvaluationStatisticsVo> statisticsByCourseTaskId(Long id);
}
