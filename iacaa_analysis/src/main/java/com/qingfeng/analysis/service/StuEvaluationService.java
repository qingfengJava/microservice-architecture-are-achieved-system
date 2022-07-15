package com.qingfeng.analysis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingfeng.analysis.beans.StuEvaluationEntity;
import com.qingfeng.analysis.beans.vo.ResultVO;

/**
 * 
 *
 * @author 清风学Java
 * @date 2022-07-12 23:39:46
 */
public interface StuEvaluationService extends IService<StuEvaluationEntity> {

    /**
     * 生成学生间接评价数据
     * @return
     */
    ResultVO create();

}

