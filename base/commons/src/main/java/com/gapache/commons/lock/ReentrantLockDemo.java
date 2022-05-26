package com.gapache.commons.lock;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static final boolean FAIR = true;

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;

    private static final int LOOP_TIMES = 100;

    static {
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000), r -> new Thread(r, "ReentrantLockDemo"), new ThreadPoolExecutor.AbortPolicy());
    }

    public static void main(String[] args) {
        final Lock used = new ReentrantLock(FAIR);
        for (int i = 0; i < LOOP_TIMES; i++) {
            THREAD_POOL_EXECUTOR.execute(() -> {
                // lock最好在try块之前并且紧贴try块调用
                used.lock();
                try {
                    System.out.println("当前线程:" + Thread.currentThread().getName() + "-" + Thread.currentThread().getId());
                } finally {
                    used.unlock();
                }
            });
        }

        while (THREAD_POOL_EXECUTOR.getActiveCount() > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        THREAD_POOL_EXECUTOR.shutdown();
    }
}
