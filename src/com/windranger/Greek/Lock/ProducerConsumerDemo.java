package com.windranger.Greek.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Storage storage = new Storage(5);
        //10个生产者
        for (int i = 0; i < 10; i++) {
            new Thread(new Producer(storage)).start();
        }
        //5个消费者
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(storage)).start();
        }
    }

}

//产品仓库类
class Storage {
    private int maxSize; // 缓冲区大小
    private List<Object> buffer;
    private final Lock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();

    public Storage(int maxSize) {
        this.maxSize = maxSize;
        buffer = new ArrayList<>();
    }

    // 写操作，生产一个产品
    public void put() {
        try {
            lock.lock();
            while (buffer.size() == maxSize) {
                System.out.println(Thread.currentThread().getName() + " Producer wait! ");
                condition.await();
            }
            buffer.add(new Object());
            System.out.println(Thread.currentThread().getName() + "：存入一个产品，现在产品数=" + buffer.size());
            condition.signalAll(); // 通知消费者
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    // 读操作，消费一个产品
    public void get() {
        lock.lock();// 加锁
        try {
            while (buffer.isEmpty()) { // 缓冲区空了
                System.out.println(Thread.currentThread().getName() + " Consumer wait！");
                condition.await();
            }
            // 消费一个产品
            buffer.remove(0); // 从链表头部移除一个
            System.out.println(Thread.currentThread().getName() + "：取出一个产品，现在产品数=" + buffer.size());
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

//生产者
class Producer implements Runnable {
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.put();
    }
}

//消费者
class Consumer implements Runnable {
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.get();
    }
}
