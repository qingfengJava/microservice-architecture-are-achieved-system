package com.gapache.commons.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class MyTest4 {

    public static void main(String[] args) {
        // -XX:MaxMetaspaceSize=200m
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));

            System.out.println("hello world");

            enhancer.create();
        }
    }
}
