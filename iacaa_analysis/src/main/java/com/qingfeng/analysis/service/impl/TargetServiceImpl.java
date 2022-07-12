package com.qingfeng.analysis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.analysis.beans.TargetEntity;
import com.qingfeng.analysis.dao.TargetDao;
import com.qingfeng.analysis.service.TargetService;
import org.springframework.stereotype.Service;


@Service("targetService")
public class TargetServiceImpl extends ServiceImpl<TargetDao, TargetEntity> implements TargetService {



}