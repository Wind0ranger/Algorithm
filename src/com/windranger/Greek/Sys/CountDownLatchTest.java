package com.windranger.Greek.Sys;

import java.util.concurrent.*;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);
        executor.execute(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {

            }
            System.out.println("----" + Thread.currentThread() + "------");

            latch.countDown();
        });
        executor.execute(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {

            }
            System.out.println("-----" + Thread.currentThread() + "-----");

            latch.countDown();
        });
        latch.await();
        System.out.println("0");
    }
}
