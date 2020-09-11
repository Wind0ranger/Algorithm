package com.windranger.Greek.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTest {
    ReentrantLock a = new ReentrantLock();
    ReentrantLock b = new ReentrantLock();

    public static void main(String[] args) {
        DeadLockTest test = new DeadLockTest();
        new Thread(() -> {
            test.getAB();
        }).start();
        new Thread(() -> {
            test.getBA();
        }).start();
    }

    private void getAB() {
        try {
            a.lock();
            System.out.println(Thread.currentThread() + "获得a锁");
            int ii = Integer.MAX_VALUE;
            while (ii > 0) {
                ii--;
            }
            try {
                b.lock();
                System.out.println(Thread.currentThread() + "获得b锁");
            } finally {
                b.unlock();
            }
        } finally {
            a.unlock();
        }
    }

    private void getBA() {
        try {
            b.lock();
            System.out.println(Thread.currentThread() + "获得b锁");
            int ii = Integer.MAX_VALUE;
            while (ii > 0) {
                ii--;
            }
            try {
                a.lock();
                System.out.println(Thread.currentThread() + "获得a锁");
            } finally {
                a.unlock();
            }
        } finally {
            b.unlock();
        }
    }
}
