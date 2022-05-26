package com.gapache.commons.jvm.classloader;

import java.lang.reflect.Method;

public class MyTest18 {

    public static void main(String[] args) throws Exception {
        // 从桌面进行加载
        MyClassLoader loader1 = new MyClassLoader("/Users/macos/Desktop/", "loader1");
        MyClassLoader loader2 = new MyClassLoader("/Users/macos/Desktop/", "loader2");

        Class<?> clazz1 = loader1.loadClass("com.gapache.commons.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.gapache.commons.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);
        // false
        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
        // 报错 ClassCastException
    }
}
