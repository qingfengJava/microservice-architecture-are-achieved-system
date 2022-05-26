package com.gapache.commons.jvm.memory;

public class StackOverflowError {

    private static void test() {
        test();
    }

    public static void main(String[] args) {
        test();
    }
}
