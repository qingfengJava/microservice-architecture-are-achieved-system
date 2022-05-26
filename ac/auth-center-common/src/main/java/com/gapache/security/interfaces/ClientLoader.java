package com.gapache.security.interfaces;

import com.gapache.security.model.ClientDTO;


public interface ClientLoader {

    /**
     * 加载PublicKey
     *
     * @param clientId clientId
     * @return 公钥
     */
    ClientDTO load(String clientId);
}
