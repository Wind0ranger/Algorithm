package com.windranger.Greek.Thread;

import java.util.concurrent.locks.*;

/**
 * @author Barry
 */
public class Account {
    public int id;
    public int balance;

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    private final Lock lock = new ReentrantLock();

    // 转账
    void transfer(Account tar, int amt) throws InterruptedException {
        while (true) {
            if (this.lock.tryLock()) {
                try {
                    if (tar.lock.tryLock()) {
                        try {
                            this.balance -= amt;
                            tar.balance += amt;
                            //新增：退出循环
                            break;
                        } finally {
                            tar.lock.unlock();
                        }
                    }//if
                } finally {
                    this.lock.unlock();
                }
            }//if
            //新增：sleep一个随机时间避免活锁
            Thread.sleep(5);
        }//while
    }//transfer

}