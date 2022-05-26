package com.gapache.security.interfaces;

import com.gapache.security.model.AccessCard;

public interface AccessCardHolderStrategy {

    void clearContext();

    AccessCard getContext();

    void setContext(AccessCard context);

    AccessCard createEmptyContext();
}
