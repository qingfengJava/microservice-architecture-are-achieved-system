package com.qingfeng.analysis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingfeng.analysis.beans.TargetEntity;
import com.qingfeng.analysis.beans.vo.CourseTargetVo;

import java.util.List;

/**
 * 
 *
 * @author qingfeng
 * @email ${email}
 * @date 2022-07-12 23:39:45
 */
public interface TargetService extends IService<TargetEntity> {

    /**
     * 根据课程Id查询指标点
     * @param courseId
     * @return
     */
    List<CourseTargetVo> findByCourseTargetId(Integer courseId, Integer year);
}

