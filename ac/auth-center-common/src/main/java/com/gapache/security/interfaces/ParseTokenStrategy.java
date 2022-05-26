package com.gapache.security.interfaces;

import com.gapache.security.model.AccessCard;

public interface ParseTokenStrategy {

    /**
     * 解析token对应的content
     *
     * @param content content
     * @return AccessCard
     */
    AccessCard parse(String content);
}
