package com.gapache.security.interfaces;

import com.gapache.security.model.AuthorizeInfoDTO;
import com.gapache.security.model.CustomerInfo;
import io.vertx.core.Future;

import java.util.Collection;

public interface AsyncAuthorizeInfoManager {

    /**
     * 保存授权后的信息
     *
     * @param token        accessToken
     * @param timeout      有效时长
     * @param customerInfo 用户自定义信息
     * @param scopes       作用域
     * @return 保存的未来结果
     */
    Future<Void> save(String token, Long timeout, CustomerInfo customerInfo, Collection<String> scopes);

    /**
     * 删除授权后的信息
     *
     * @param token token
     * @return 删除的未来结果
     */
    Future<Void> delete(String token);

    /**
     * info
     *
     * @param token token
     * @return info
     */
    Future<AuthorizeInfoDTO> get(String token);
}
