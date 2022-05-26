package com.gapache.cloud.auth.server.constant;

public enum ResponseType {
    // 要求返回授权码
    code,
    // 要求直接返回token（隐密式）
    token
}
