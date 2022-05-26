package com.gapache.commons.loader;

import java.util.List;

public interface DataLoader<T> {

    /**
     * 加载
     *
     * @return 加载到的数据
     */
    List<T> loading();
}
