package com.gapache.commons.jvm.memory;

import java.util.ArrayList;
import java.util.List;

public class MyTest1 {

    public static void main(String[] args) {
        // -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
        // 堆内存溢出
        List<MyTest1> list = new ArrayList<>();
        for (;;) {
            list.add(new MyTest1());

            System.gc();
        }
    }

}
