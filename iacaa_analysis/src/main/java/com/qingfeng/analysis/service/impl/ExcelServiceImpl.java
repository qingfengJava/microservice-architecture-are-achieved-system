package com.qingfeng.analysis.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.qingfeng.analysis.beans.ExcelStuEntity;
import com.qingfeng.analysis.beans.ExcelTaskCheckEntity;
import com.qingfeng.analysis.beans.vo.ExcelRuleVo;
import com.qingfeng.analysis.beans.vo.ExcelStuVo;
import com.qingfeng.analysis.dao.ExcelDao;
import com.qingfeng.analysis.service.ExcelService;
import com.qingfeng.analysis.util.EasyPoiUtils;
import com.qingfeng.analysis.util.ExcelStyleUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
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
//        EasyPoiUtils.exportExcelByRule(rules, courseName + "评分细则", "评分细则", ExcelRuleVo.class, courseName + ".xlsx", response);
        List<ExcelStuVo> stus = getStu(id, year);
        //创建评分细则表
        ExportParams exportParams = new ExportParams(courseName + "评分细则", "评分细则");
        exportParams.setType(ExcelType.XSSF);
        exportParams.setCreateHeadRows(true);
        exportParams.setStyle(ExcelStyleUtils.class);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, ExcelRuleVo.class, rules);
        //创建成绩表
        Sheet sheet2 = workbook.createSheet("成绩");
        //基础样式
        CellStyle style = ExcelStyleUtils.getBaseCellStyle(workbook);
        Row r1 = sheet2.createRow(0);
        Cell c11 = r1.createCell(0);
        c11.setCellValue("班级学生");
        c11.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(0, 1, 0, 1));
        Row row3 = sheet2.createRow(2);
        Cell c31 = row3.createCell(0);
        c31.setCellValue("序号");
        c31.setCellStyle(style);
        Cell c32 = row3.createCell(1);
        c32.setCellValue("学号");
        c32.setCellStyle(style);
        Row row2 = sheet2.createRow(1);
        //学生数,从单元格索引为3开始
        int stuCount = 3, j = 1;
        for (ExcelStuVo stuVo : stus) {
            //前两列数据 学生序号和学号
            Row row = sheet2.createRow(stuCount);
            Cell cell = row.createCell(0);
            cell.setCellValue(stuCount - 2);
            cell.setCellStyle(style);
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(stuVo.getUid());
            cell1.setCellStyle(style);
            sheet2.autoSizeColumn(0);
            sheet2.setColumnWidth(0, sheet2.getColumnWidth(0) * 17 / 10); // 中文宽度
            sheet2.autoSizeColumn(1);
            sheet2.setColumnWidth(1, sheet2.getColumnWidth(1) * 17 / 10); // 中文宽度
            //目标成绩数据
            int taskNum = stuVo.getTak().size(), i = 1, x = 1, y = 1;
            for (ExcelStuEntity tak : stuVo.getTak()) {
                if (j < taskNum * 2 + 1) {
                    Cell cell2 = r1.createCell(j + i);
                    cell2.setCellValue("目标" + y++);
                    cell2.setCellStyle(style);
                    sheet2.addMergedRegion(new CellRangeAddress(0, 0, j + i, j + i + 1));
                    j += 2;
                }
                for (ExcelTaskCheckEntity task : tak.getTasks()) {
                    Cell cell3 = row2.createCell(i + x);
                    cell3.setCellValue(task.getTaskName());
                    cell3.setCellStyle(style);
                    Row row4 = sheet2.getRow(2);
                    Cell cell4 = row4.createCell(i + x);
                    cell4.setCellValue("100");
                    CellStyle styleColor = ExcelStyleUtils.getBaseCellStyle(workbook);
                    styleColor.setFillForegroundColor(IndexedColors.RED.getIndex());
                    styleColor.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    cell4.setCellStyle(styleColor);

                    Cell cell5 = row.createCell(i + x);
                    cell5.setCellValue(task.getScore());
                    cell5.setCellStyle(style);
                    x++;
                }
            }
            ++stuCount;
        }
        EasyPoiUtils.downLoadExcel(courseName + ".xlsx", response, workbook);
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
