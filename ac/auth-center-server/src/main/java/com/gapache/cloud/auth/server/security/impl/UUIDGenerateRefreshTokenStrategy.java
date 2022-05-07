package com.gapache.cloud.auth.server.security.impl;

import com.gapache.cloud.auth.server.security.GenerateRefreshTokenStrategy;

import java.util.Map;
import java.util.UUID;

/**
 * @author 清风学Java
 * @since 2020/8/4 7:22 下午
 */
public class UUIDGenerateRefreshTokenStrategy implements GenerateRefreshTokenStrategy {

    @Override
    public String generate(Map<String, Object> params) {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
