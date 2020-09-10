package com.windranger.Thread.ThreadLocal;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadPoolTest {

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2, 2, 1,
                        TimeUnit.SECONDS, workQueue, new MyThreadFactory(), new RejectPolicy());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new MyTask(i));
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.execute(new MyTask(11));
    }

    static class MyThreadFactory implements ThreadFactory {
        final static AtomicInteger ii = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "myThread-" + ii.incrementAndGet());
        }
    }

    static class ThreadId {
        static final AtomicInteger atomic = new AtomicInteger(1);
        /**
         * 定义ThreadLocal变量
         */
        static final ThreadLocal<Integer> tl =
                ThreadLocal.withInitial(atomic::getAndIncrement);

        /**
         * 此方法会为每个线程分配一个唯一的Id
         */
        static long get() {
            System.out.println(tl);
            return tl.get();
        }
    }

    static class RejectPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            doLog(r, executor);
        }

        private void doLog(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(r.toString() + " is reject");
        }
    }

    static class MyTask implements Runnable {
        private final Integer name;

        public MyTask(int name) {
            this.name = name;
        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "执行" + name + " loacal:" + ThreadId.get());
        }
    }
}
