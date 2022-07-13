package com.qingfeng.analysis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingfeng.analysis.beans.CourseEntity;

import java.util.List;

/**
 * 
 *
 * @author qingfeng
 * @email ${email}
 * @date 2022-07-12 23:39:47
 */
public interface CourseService extends IService<CourseEntity> {

    /**
     * 查询所有课程
     * @return
     */
    List<CourseEntity> findAll();
}

