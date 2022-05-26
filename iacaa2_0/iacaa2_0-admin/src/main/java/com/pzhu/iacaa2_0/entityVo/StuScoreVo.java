package com.pzhu.iacaa2_0.entityVo;

import com.pzhu.iacaa2_0.entity.StuScore;
import lombok.Data;

@Data
public class StuScoreVo extends StuScore {
    private Integer year;
    private Long courseId;
}
