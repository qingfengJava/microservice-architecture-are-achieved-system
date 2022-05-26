package com.gapache.uid.worker;

public interface WorkerIdAssigner {

    /**
     * Assign worker id for {@link com.gapache.uid.impl.DefaultUidGenerator}
     *
     * @return assigned worker id
     */
    long assignWorkerId();
}
