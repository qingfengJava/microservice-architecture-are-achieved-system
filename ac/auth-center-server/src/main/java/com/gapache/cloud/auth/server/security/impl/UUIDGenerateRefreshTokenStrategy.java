package com.gapache.cloud.auth.server.security.impl;

import com.gapache.cloud.auth.server.security.GenerateRefreshTokenStrategy;

import java.util.Map;
import java.util.UUID;

public class UUIDGenerateRefreshTokenStrategy implements GenerateRefreshTokenStrategy {

    @Override
    public String generate(Map<String, Object> params) {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
