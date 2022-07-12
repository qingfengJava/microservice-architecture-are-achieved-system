package com.qingfeng.analysis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.analysis.beans.CheckLinkEntity;
import com.qingfeng.analysis.dao.CheckLinkDao;
import com.qingfeng.analysis.service.CheckLinkService;
import org.springframework.stereotype.Service;


@Service("checkLinkService")
public class CheckLinkServiceImpl extends ServiceImpl<CheckLinkDao, CheckLinkEntity> implements CheckLinkService {


}