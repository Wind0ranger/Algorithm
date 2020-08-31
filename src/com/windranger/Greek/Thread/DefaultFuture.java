package com.windranger.Greek.Thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class DefaultFuture {

    // 创建锁与条件变量
    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();
    private String response;

    // 调用方通过该方法等待结果
    Object get(int timeout) throws TimeoutException {
        long start = System.nanoTime();
        lock.lock();
        try {
            while (!isDone()) {
                done.await(timeout, TimeUnit.MINUTES);
                long cur = System.nanoTime();
                if (isDone() || cur - start > timeout) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        if (!isDone()) {
            throw new TimeoutException();
        }
        return response;
    }

    // RPC结果是否已经返回
    boolean isDone() {
        return response != null;
    }

    // RPC结果返回时调用该方法
    private void doReceived(String res) {
        lock.lock();
        try {
            response = res;
            done.signal();
        } finally {
            lock.unlock();
        }
    }

}
