package com.gapache.security.checker;

import com.gapache.security.model.AccessCard;

public interface SecurityChecker {

    /**
     * 检查并解析token
     *
     * @param token token
     * @return 凭证
     */
    AccessCard checking(String token);
}
