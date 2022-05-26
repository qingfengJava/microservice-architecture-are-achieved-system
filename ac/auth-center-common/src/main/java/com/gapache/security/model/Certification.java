package com.gapache.security.model;

import java.io.Serializable;
import java.security.Principal;

public interface Certification extends Principal, Serializable {

    /**
     * 凭证对应的唯一ID
     *
     * @return 唯一ID
     */
    Long getUniqueId();
}
