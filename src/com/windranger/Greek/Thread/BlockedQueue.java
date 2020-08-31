package com.windranger.Greek.Thread;


import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class BlockedQueue<T> {
    final Lock lock = new ReentrantLock();
    // 条件变量：队列不满
    final Condition notFull = lock.newCondition();
    // 条件变量：队列不空
    final Condition notEmpty = lock.newCondition();
    Deque<T> deque = new LinkedList<>();

    // 入队
    void enq(T x) {
        lock.lock();
        try {
            while (deque.size() >= 2) {
                // 等待队列不满
                notFull.await();
            }
            // 省略入队操作...
            //入队后,通知可出队
            deque.add(x);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 出队
    void deq() {
        lock.lock();
        try {
            while (deque.size() == 0) {
                // 等待队列不空
                notEmpty.await();
            }
            //
            System.out.println(deque.pop());
            //出队后，通知可入队
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockedQueue<Integer> queue = new BlockedQueue<>();
        queue.enq(1);
        queue.enq(2);
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(() -> {
            queue.enq(1);
        });
        threadPool.execute(() -> {
            queue.deq();
        });
        threadPool.shutdown();
    }
}