package com.gapache.cloud.auth.server.constant;


public enum GrantType {
    // 授权码
    authorization_code,
    // 隐秘
    implicit,
    // 密码
    password,
    // 客户端
    client_credentials,
    // 刷新token
    refresh_token
}
