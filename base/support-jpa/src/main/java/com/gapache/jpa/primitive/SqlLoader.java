package com.gapache.jpa.primitive;

public interface SqlLoader {
    
    /**
     * 加载sql语句
     *
     * @return sql语句
     */
    String loading();

    /**
     * 是否已加载
     *
     * @return 是否已加载
     */
    boolean loaded();
}
