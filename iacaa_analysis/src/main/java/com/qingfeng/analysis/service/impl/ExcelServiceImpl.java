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
import java.util.ArrayList;
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
        ExportParams exportParams = new ExportParams(courseName + "考核环节", "考核环节");
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
        int stuCount = 3, j = 1, index = 2, o = 1;
        for (ExcelStuEntity e : stus.get(0).getTak()) {
            Cell cell4 = r1.createCell(index);
            cell4.setCellValue("目标" + o);
            cell4.setCellStyle(style);
            int x = index;
            for (ExcelTaskCheckEntity task : e.getTasks()) {
                Cell cell3 = row2.createCell(index++);
                cell3.setCellValue(task.getTaskName());
                CellStyle styleColor = ExcelStyleUtils.getBaseCellStyle(workbook);
                styleColor.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
                styleColor.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell3.setCellStyle(styleColor);
            }
            sheet2.addMergedRegion(new CellRangeAddress(0, 0, x, index - 1));
            o++;
        }
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
                for (ExcelTaskCheckEntity task : tak.getTasks()) {
                    Cell cell3 = row2.createCell(i + x);
                    cell3.setCellValue(task.getTaskName());
                    cell3.setCellStyle(style);
                    Row row4 = sheet2.getRow(2);
                    Cell cell4 = row4.createCell(i + x);
                    cell4.setCellValue("100");
                    CellStyle styleColor = ExcelStyleUtils.getBaseCellStyle(workbook);
                    styleColor.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
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


        int takNum = stus.get(0).getTak().size();
        int i = index;
        Cell cell = r1.createCell(i);
        cell.setCellValue("成绩");
        sheet2.addMergedRegion(new CellRangeAddress(0, 0, i, i + takNum));
        cell.setCellStyle(style);
        Cell cell1 = row2.createCell(i);
        cell1.setCellValue("得分");
        cell1.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(1, 1, i, i + takNum - 1));

        for (int k = 1; k <= takNum; k++) {
            Cell cell2 = row3.createCell(i + k - 1);
            cell2.setCellValue("目标" + k);
            cell2.setCellStyle(style);
        }

        Cell cell2 = row2.createCell(i + takNum);
        cell2.setCellValue("总分");
        cell2.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(1, 2, i + takNum, i + takNum));

        int newIndex = i + takNum + 1, k = 1, y = newIndex;
        ArrayList<Double> mixs = new ArrayList<>();
        for (ExcelStuEntity e : stus.get(0).getTak()) {
            Cell cell4 = row2.createCell(newIndex);
            cell4.setCellValue("目标" + k);
            cell4.setCellStyle(style);
            int x = newIndex;
            for (ExcelTaskCheckEntity task : e.getTasks()) {
                Cell cell3 = row3.createCell(newIndex++);
                cell3.setCellValue(task.getMix() + "");
                mixs.add(task.getMix());
                CellStyle styleColor = ExcelStyleUtils.getBaseCellStyle(workbook);
                styleColor.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                styleColor.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell3.setCellStyle(styleColor);
            }
            sheet2.addMergedRegion(new CellRangeAddress(1, 1, x, newIndex - 1));
            k++;
        }
        Cell cell3 = r1.createCell(y);
        cell3.setCellValue("达成度");
        cell3.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(0, 0, y, newIndex - 1));

        Cell cell4 = r1.createCell(newIndex);
        cell4.setCellValue("达成值");
        cell4.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(0, 1, newIndex, newIndex + takNum - 1));

        for (int l = 1; l <= takNum; l++) {
            Cell cell5 = row3.createCell(newIndex++);
            cell5.setCellValue("目标" + l);
            cell5.setCellStyle(style);
        }

        for (int l = index; l < newIndex; l++) {
            for (int m = 0; m < 3; m++) {
                putData(1, m, l, workbook);
            }
        }

        int stuNum = 3, lastNumber = 0;
        for (ExcelStuVo stuVo : stus) {
            int i1 = 0, u = index;
            double sAll = 0.0;
            Row row = sheet2.getRow(stuNum);
            for (ExcelStuEntity e : stuVo.getTak()) {
                double s = 0.0;
                for (ExcelTaskCheckEntity task : e.getTasks()) {
                    s += task.getScore() * task.getMix();
                }
                Cell cell5 = row.createCell(u++);
                cell5.setCellValue(s / 2);
                sAll += s;
                CellStyle styleColor = ExcelStyleUtils.getBaseCellStyle(workbook);
                styleColor.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
                styleColor.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell5.setCellStyle(styleColor);
            }
            Cell cell5 = row.createCell(u++);
            cell5.setCellValue(sAll / 2);
            CellStyle styleColor = ExcelStyleUtils.getBaseCellStyle(workbook);
            styleColor.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            styleColor.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cell5.setCellStyle(styleColor);

            ArrayList<Double> das = new ArrayList<>();
            for (ExcelStuEntity e : stuVo.getTak()) {
                double da = 0.0;
                for (ExcelTaskCheckEntity task : e.getTasks()) {
                    Cell cell6 = row.createCell(u++);
                    cell6.setCellValue(task.getReach());
                    cell6.setCellStyle(style);
                    da += task.getReach() * task.getMix();
                }
                das.add(da);
            }
            for (ExcelStuEntity e : stuVo.getTak()) {
                Cell cell6 = row.createCell(u++);
                cell6.setCellValue(das.get(i1++));
                cell6.setCellStyle(style);
            }
            stuNum++;
            lastNumber = u;
        }

        String[] zimu = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Row row = sheet2.createRow(stuNum);
        Cell cell5 = row.createCell(0);
        cell5.setCellStyle(style);
        cell5.setCellValue("平均值");
        sheet2.addMergedRegion(new CellRangeAddress(stuNum, stuNum, 0, 1));
        putData(1, stuNum, 1, workbook);
        workbook.setForceFormulaRecalculation(true);
        for (int l = 2; l < lastNumber; l++) {
            Cell cell6 = row.createCell(l);
            if (l > 25) {
                cell6.setCellFormula("AVERAGE(A" + zimu[l - 26] + "4:" + "A" + zimu[l - 26] + stuNum + ")");
            } else {
                cell6.setCellFormula("AVERAGE(" + zimu[l] + "4:" + zimu[l] + stuNum + ")");
            }
            CellStyle styleColor = ExcelStyleUtils.getBaseCellStyle(workbook);
            DataFormat format = workbook.createDataFormat();
            styleColor.setDataFormat(format.getFormat("00.000"));
            styleColor.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
            styleColor.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cell6.setCellStyle(styleColor);
        }
        EasyPoiUtils.downLoadExcel(courseName + ".xlsx", response, workbook);
    }

    public void putData(int shtidx, int rowidx, int colidx, Workbook wb) {
        Sheet sht = wb.getSheetAt(shtidx);
        if (sht.getRow(rowidx) == null) {
            sht.createRow(rowidx);
        }
        Row row = sht.getRow(rowidx);
        if (row.getCell(colidx) == null) {
            Cell cell = row.createCell(colidx);
            cell.setCellStyle(ExcelStyleUtils.getBaseCellStyle(wb));
        }
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
