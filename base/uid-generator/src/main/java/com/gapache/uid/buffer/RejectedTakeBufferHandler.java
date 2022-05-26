package com.gapache.uid.buffer;

@FunctionalInterface
public interface RejectedTakeBufferHandler {

    /**
     * Reject take buffer request
     *
     * @param ringBuffer RingBuffer
     */
    void rejectTakeBuffer(RingBuffer ringBuffer);
}
