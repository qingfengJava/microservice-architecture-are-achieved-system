package com.qingfeng.analysis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.analysis.beans.GradRequirementEntity;
import com.qingfeng.analysis.dao.GradRequirementDao;
import com.qingfeng.analysis.service.GradRequirementService;
import org.springframework.stereotype.Service;


@Service("gradRequirementService")
public class GradRequirementServiceImpl extends ServiceImpl<GradRequirementDao, GradRequirementEntity> implements GradRequirementService {


}