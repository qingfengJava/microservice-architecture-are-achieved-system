package com.gapache.cloud.auth.server.security;

import com.gapache.cloud.auth.server.model.CodeCacheInfoDTO;
import com.gapache.security.model.CustomerInfo;

public interface CodeStrategy {

    /**
     * 生成授权码
     *
     * @param uid          唯一ID
     * @param name         名称
     * @param customerInfo 自定义信息
     * @return 授权码
     */
    String generate(Long uid, String name, CustomerInfo customerInfo);

    /**
     * 获取授权码信息
     *
     * @param code 授权码
     * @return 授权码信息
     */
    CodeCacheInfoDTO get(String code);

    /**
     * 删除授权码
     *
     * @param code 授权码
     */
    void delete(String code);
}
