package com.pzhu.iacaa2_0.entityVo;

import com.pzhu.iacaa2_0.entity.StuEvaluation;
import lombok.Data;

@Data
public class StuEvaluationVo extends StuEvaluation {
    CourseTaskVo courseTaskVo;
}
