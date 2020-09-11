package com.windranger.Greek.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptiblyTest {
    static ReentrantLock lock = new ReentrantLock();
    public void doSomeThing3(Thread thread) {
        try {
            System.out.println(thread.getName() + " 得到了锁.");
            lock.lockInterruptibly();
            Thread.sleep(6000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
            System.out.println(thread.getName() + " interrupted.");
        } finally {
            System.out.println(thread.getName() + " 释放了锁.");
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        final InterruptiblyTest lockDemo = new InterruptiblyTest();

        Thread threada = new Thread("Thread A") {
            @Override
            public void run() {
                lockDemo.doSomeThing3(Thread.currentThread());
            }
        };
        threada.start();

        Thread threadb = new Thread("Thread B") {
            @Override
            public void run() {
                lockDemo.doSomeThing3(Thread.currentThread());
            }
        };
        threadb.start();
        threada.interrupt();
    }

}
