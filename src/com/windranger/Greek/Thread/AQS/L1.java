package com.windranger.Greek.Thread.AQS;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class L1 {
    public static volatile int m = 0;

    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
//                synchronized (L1.class){
//                    for (int j = 0; j < 1000; j++) {
//                        m++;
//                    }
//                }
                try{
                    lock.lock();
                    for (int j = 0; j < 1000; j++) {
                        m++;
                    }
                }finally {
                    lock.unlock();
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(m);
    }
}
