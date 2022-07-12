package com.qingfeng.analysis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.analysis.beans.StuEvaluationEntity;
import com.qingfeng.analysis.dao.StuEvaluationDao;
import com.qingfeng.analysis.service.StuEvaluationService;
import org.springframework.stereotype.Service;


@Service("stuEvaluationService")
public class StuEvaluationServiceImpl extends ServiceImpl<StuEvaluationDao, StuEvaluationEntity> implements StuEvaluationService {


}