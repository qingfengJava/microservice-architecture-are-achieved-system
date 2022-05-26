package com.gapache.security.checker;

import com.gapache.security.model.AccessCard;
import io.vertx.core.Future;

public interface AsyncSecurityChecker {

    /**
     * 检查并解析token
     *
     * @param token token
     * @return 凭证
     */
    Future<AccessCard> checking(String token);
}
