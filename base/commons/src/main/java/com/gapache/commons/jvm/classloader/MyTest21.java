package com.gapache.commons.jvm.classloader;

public class MyTest21 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(Thread.class.getClassLoader());
        // null
    }
}
