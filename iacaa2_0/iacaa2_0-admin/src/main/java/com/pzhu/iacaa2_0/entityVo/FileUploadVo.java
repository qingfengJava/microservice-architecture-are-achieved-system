package com.pzhu.iacaa2_0.entityVo;

import com.pzhu.iacaa2_0.entity.Course;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadVo {
    private MultipartFile file;
    private Course course;
    private Integer year;
}
