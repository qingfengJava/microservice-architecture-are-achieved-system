package com.qingfeng.analysis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.analysis.beans.StuScoreEntity;
import com.qingfeng.analysis.dao.StuScoreDao;
import com.qingfeng.analysis.service.StuScoreService;
import org.springframework.stereotype.Service;


@Service("stuScoreService")
public class StuScoreServiceImpl extends ServiceImpl<StuScoreDao, StuScoreEntity> implements StuScoreService {


}