package com.pzhu.iacaa2_0.entityVo;

import com.pzhu.iacaa2_0.entity.GradRequirement;
import com.pzhu.iacaa2_0.entity.Target;
import lombok.Data;

import java.util.List;

@Data
public class GradRequirementVo extends GradRequirement {
    private String word;
    private List<Target> targets;
}
