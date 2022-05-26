package com.gapache.commons.jvm.classloader;

public class MyTest19 {

    static {
        System.out.println("MyTest19 initializer");
    }

    public static void main(String[] args) {
        System.out.println(MyTest19.class.getClassLoader());

        System.out.println(MyTest1.class.getClassLoader());
    }
}
