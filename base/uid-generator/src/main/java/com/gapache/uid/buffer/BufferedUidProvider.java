package com.gapache.uid.buffer;

import java.util.List;

@FunctionalInterface
public interface BufferedUidProvider {

    /**
     * Provides UID in one second
     *
     * @param momentInSecond 当前的秒数
     * @return UID in one second
     */
    List<Long> provide(long momentInSecond);
}
