package com.gapache.uid.buffer;

@FunctionalInterface
public interface RejectedPutBufferHandler {

    /**
     * Reject put buffer request
     *
     * @param ringBuffer RingBuffer
     * @param uid        uid
     */
    void rejectPutBuffer(RingBuffer ringBuffer, long uid);
}
