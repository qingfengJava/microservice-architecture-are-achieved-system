package com.qingfeng.analysis.service.impl;

import cn.afterturn.easypoi.word.WordExportUtil;
import com.qingfeng.analysis.beans.CourseEntity;
import com.qingfeng.analysis.dao.CourseDao;
import com.qingfeng.analysis.dao.TargetDao;
import com.qingfeng.analysis.service.WordService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/7/14
 */
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private TargetDao targetDao;

    @Override
    public void exportWord(Integer courseId, Integer year, HttpServletResponse response) throws Exception {
        //查询课程信息
        CourseEntity courseEntity = courseDao.selectById(courseId);

        //获取到模板
        File file = new File("iacaa_analysis/src/main/resources/word_template/"+courseEntity.getName()+".docx");

        //封装map信息
        HashMap<String, Object> params = new HashMap<>(16);


        /*//封装课程信息
        params.put("id",Integer.toString(courseEntity.getId()));
        params.put("name", courseEntity.getName());

        //查询指标点课程目标等信息
        List<CourseTargetVo> courseTargetVoList = targetDao.findByCourseTargetId(courseId, year);
        //封装指标信息
        ArrayList<Map> targetList = new ArrayList<>();
        Map<String, Object> targetMap = null;
        for (CourseTargetVo courseTargetVo : courseTargetVoList) {
            targetMap = new HashMap<>(16);
            targetMap.put("tgd",courseTargetVo.getDiscribe().substring(0,4));
            //封装课程目标
            ArrayList<Map> courseTaskList = new ArrayList<>();
            Map<String, Object> courseTaskMap = null;
            for (CourseTaskVo courseTaskVo : courseTargetVo.getCourseTaskVoList()) {
                courseTaskMap = new HashMap<>(16);
                courseTaskMap.put("tsd",courseTaskVo.getDescribes().substring(0,3));
                courseTaskMap.put("tsm",courseTaskVo.getMix());
                courseTaskMap.put("tsg", courseTaskVo.getSysGrade());
                //封装考核环节
                ArrayList<Map> checkLinkList = new ArrayList<>();
                Map<String, Object> checkLinkMap = null;
                for (CheckLinkVo checkLinkVo : courseTaskVo.getCheckLinkVoList()) {
                    checkLinkMap = new HashMap<>(16);
                    checkLinkMap.put("linkName",checkLinkVo.getName());
                    checkLinkMap.put("targetScore",checkLinkVo.getTargetScore());
                    checkLinkMap.put("averageScore",checkLinkVo.getAverageScore());
                    checkLinkMap.put("linkMix",checkLinkVo.getMix());
                    checkLinkMap.put("dacheng",checkLinkVo.getAverageScore()+"%");

                    checkLinkList.add(checkLinkMap);
                }

                courseTaskMap.put("cl",checkLinkList);
                courseTaskList.add(courseTaskMap);
            }
            targetMap.put("tsl",courseTaskList);
            targetList.add(targetMap);
        }

        params.put("tgl", targetList);*/

        XWPFDocument wordDocument = WordExportUtil.exportWord07(file.getPath(), params);


        // 模板文档结合数据进行操作
        String filename = "工程教育认证-"+courseEntity.getName()+"-课程目标达成评价表.docx";
        response.setHeader("content-disposition", "attachment;filename=" + new String(filename.getBytes(), "ISO8859-1"));
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        wordDocument.write(response.getOutputStream());
    }
}
