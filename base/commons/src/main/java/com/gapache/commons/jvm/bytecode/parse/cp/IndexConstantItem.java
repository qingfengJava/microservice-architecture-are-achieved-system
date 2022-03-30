package com.gapache.commons.jvm.bytecode.parse.cp;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhaoZezhong
 * create on 2020/3/28 00:34
 */
@Getter
@Setter
public class IndexConstantItem extends ConstantItem {
    private int[] indexes;
}
