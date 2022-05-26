package com.pzhu.iacaa2_0.entityVo;

import com.pzhu.iacaa2_0.entity.CheckLink;
import com.pzhu.iacaa2_0.entity.Course;
import com.pzhu.iacaa2_0.entity.CourseTask;
import com.pzhu.iacaa2_0.entity.CourseTaskCheckLink;
import lombok.Data;

@Data
public class CourseTaskCheckLinkVo extends CourseTaskCheckLink {
    CourseTask courseTask;
    CheckLink checkLink;
}
