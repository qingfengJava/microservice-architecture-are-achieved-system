package com.gapache.commons.jvm.memory;

public class MyTest3 {

    public static void main(String[] args) {
        new Thread(A::method, "Thread-A").start();
        new Thread(B::method, "Thread-B").start();
    }
}

class A {

    public static synchronized void method() {
        System.out.println("method from A");
        System.out.println(A.class);

        try {
            Thread.sleep(5000);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B {

    public static synchronized void method() {
        System.out.println("method from B");
        System.out.println(B.class);

        try {
            Thread.sleep(5000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
