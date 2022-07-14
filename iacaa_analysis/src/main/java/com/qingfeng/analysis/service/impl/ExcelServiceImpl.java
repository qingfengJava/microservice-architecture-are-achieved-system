package com.qingfeng.analysis.service.impl;

import com.qingfeng.analysis.beans.ExcelStuEntity;
import com.qingfeng.analysis.beans.ExcelTaskCheckEntity;
import com.qingfeng.analysis.beans.vo.ExcelRuleVo;
import com.qingfeng.analysis.beans.vo.ExcelStuVo;
import com.qingfeng.analysis.dao.ExcelDao;
import com.qingfeng.analysis.service.ExcelService;
import com.qingfeng.analysis.util.EasyPoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author KK
 * @CreateTime 2022/7/14
 */
@Service("excelService")
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private ExcelDao dao;

    @Override
    public void getExcel(HttpServletResponse response, String id, String year) throws IOException {
        List<ExcelRuleVo> rules = dao.getRule(id, year);
        String courseName = rules.get(0).getCourseName();
        EasyPoiUtils.exportExcelByRule(rules, courseName + "评分细则", "评分细则", ExcelRuleVo.class, courseName + ".xlsx", response);

    }

    @Override
    public List<ExcelStuVo> getStu(String id, String year) {
        List<ExcelStuVo> stu = dao.getStu(id, year);
        for (ExcelStuVo s : stu) {
            for (ExcelStuEntity ese : s.getTak()) {
                for (ExcelTaskCheckEntity task : ese.getTasks()) {
                    double v = task.getReach() * task.getMix();
                    if (Objects.isNull(ese.getReachTar())) {
                        ese.setReachTar(v);
                    } else {
                        ese.setReachTar(ese.getReachTar() + v);
                    }
                    double v1 = task.getScore() * task.getMix();
                    if (Objects.isNull(ese.getScoreTar())) {
                        ese.setScoreTar(v1 / 2.0);
                    } else {
                        ese.setScoreTar(ese.getScoreTar() + v1 / 2.0);
                    }

                }
            }
        }
        for (ExcelStuVo s : stu) {
            for (ExcelStuEntity ese : s.getTak()) {
                Double scoreTar = ese.getScoreTar();
                if (s.getScoreAll() == null) {
                    s.setScoreAll(scoreTar);
                } else {
                    s.setScoreAll(s.getScoreAll() + scoreTar);
                }
            }
        }
        return stu;
    }
}
