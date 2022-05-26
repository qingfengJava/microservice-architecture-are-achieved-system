package com.gapache.uid.worker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisposableWorkerIdAssigner implements WorkerIdAssigner {

    @Override
    public long assignWorkerId() {
        return 0;
    }
}
