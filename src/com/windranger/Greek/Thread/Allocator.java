package com.windranger.Greek.Thread;


import java.util.*;
import java.util.concurrent.*;

class Allocator {
    private List<Account> als = new LinkedList<>();

    /**
     * 一次性申请所有资源
     */

    synchronized void apply(Account from, Account to) {
        // 经典写法
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (Exception ignored) {
            }
        }
        als.add(from);
        als.add(to);
    }

    synchronized void free(Account from, Account to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }

    public static void main(String[] args) {
        Allocator allocator = new Allocator();
        Account a = new Account(1, 1);
        Account b = new Account(2, 2);
        Account c = new Account(3, 3);
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            threadPool.execute(() -> {
                allocator.apply(a, b);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                allocator.free(a, b);
            });
        }
    }
}