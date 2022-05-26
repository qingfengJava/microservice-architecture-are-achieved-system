package com.gapache.cloud.auth.server.security;

import java.util.Map;

public interface GenerateRefreshTokenStrategy {

    /**
     * 生成refresh token
     *
     * @param params 生成refresh token的参数
     * @return refreshToken
     */
    String generate(Map<String, Object> params);
}
