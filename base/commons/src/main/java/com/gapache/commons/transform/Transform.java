package com.gapache.commons.transform;

public interface Transform<T, R> {

    /**
     * R转T
     *
     * @param r R
     * @return t
     */
    T toT(R r);

    /**
     * T转R
     *
     * @param t T
     * @return r
     */
    R toR(T t);

}
