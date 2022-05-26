package com.gapache.commons.lock;

import java.io.Serializable;

public abstract class AbstractGapacheOwnableSynchronizer implements Serializable {
    private static final long serialVersionUID = 5434878576818575861L;

    protected AbstractGapacheOwnableSynchronizer() {}

    private transient Thread exclusiveOwnerThread;

    protected final void setExclusiveOwnerThread(Thread thread) {
        this.exclusiveOwnerThread = thread;
    }

    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }
}
