package com.windranger.Greek.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    private ReentrantLock lock = new ReentrantLock();

    public void doSomeThing(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName() + "得到了锁.");
            Thread.sleep(1000000000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(thread.getName() + "释放了锁.");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final TestLock lockDemo = new TestLock();

        Thread threada = new Thread("Thread A") {
            @Override
            public void run() {
                lockDemo.doSomeThing(Thread.currentThread());
            }
        };
        threada.start();

        Thread threadb = new Thread("Thread B") {
            @Override
            public void run() {
                lockDemo.doSomeThing(Thread.currentThread());
            }
        };
        threadb.start();
    }

}
