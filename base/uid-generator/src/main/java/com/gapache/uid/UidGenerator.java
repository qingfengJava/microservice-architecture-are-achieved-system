package com.gapache.uid;

import com.gapache.uid.exception.UidGenerateException;

public interface UidGenerator {

    /**
     * Get a unique ID
     *
     * @return UID
     * @throws UidGenerateException UidGenerateException
     */
    long getUID() throws UidGenerateException;

    /**
     * Parse the UID into elements which are used to generate the UID. <br>
     * Such as timestamp & workerId & sequence...
     *
     * @param uid UID
     * @return Parsed info
     */
    String parseUID(long uid);
}
