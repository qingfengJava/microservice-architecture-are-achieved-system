package com.gapache.security.interfaces;

import java.util.Map;

public interface GenerateTokenStrategy {

    /**
     * 生成token
     *
     * @param params 生成token需要的参数，由实现类自己定义
     * @return token
     */
    String generate(Map<String, Object> params);
}
