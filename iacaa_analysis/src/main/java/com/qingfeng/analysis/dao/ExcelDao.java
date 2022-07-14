package com.qingfeng.analysis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingfeng.analysis.beans.vo.ExcelRuleVo;
import com.qingfeng.analysis.beans.vo.ExcelStuVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExcelDao  extends BaseMapper<ExcelRuleVo> {

    /**
     * 根据课程id查询对应的excel中评价规则的vo实体
     *
     * @param id
     * @return
     */
    List<ExcelRuleVo> getRule(String id, String year);

    /**
     * 根据课程id对应的excel中成绩表
     * @param id
     * @param year
     * @return
     */
    List<ExcelStuVo> getStu(String id,String year);
}
