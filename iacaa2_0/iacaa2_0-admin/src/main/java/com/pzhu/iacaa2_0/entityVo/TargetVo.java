package com.pzhu.iacaa2_0.entityVo;

import com.pzhu.iacaa2_0.entity.Target;
import lombok.Data;

@Data
public class TargetVo extends Target {
    private String reqName;
    private String word;
}
