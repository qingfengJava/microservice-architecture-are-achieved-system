package com.gapache.uid.worker;

import com.gapache.uid.utils.ValuedEnum;

public enum WorkerNodeType implements ValuedEnum<Integer> {

    CONTAINER(1), ACTUAL(2);

    /**
     * Lock type
     */
    private final Integer type;

    WorkerNodeType(Integer type) {
        this.type = type;
    }

    @Override
    public Integer value() {
        return this.type;
    }
}
