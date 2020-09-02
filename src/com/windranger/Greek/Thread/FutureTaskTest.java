package com.windranger.Greek.Thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FutureTaskTest {
    static class MyThreadFactory implements ThreadFactory{

        private final AtomicInteger atomicInteger = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"myThread - " + atomicInteger.incrementAndGet());
        }
    }
    final static int poolSize = 5;
    final static int maxPoolSize = poolSize * 4;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建任务T2的FutureTask
        FutureTask<String> ft2 = new FutureTask<>(new T2Task());
        // 创建任务T1的FutureTask
        FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));
        // 线程T1执行任务ft1
        ThreadPoolExecutor executor = new ThreadPoolExecutor(poolSize,maxPoolSize,
                1,TimeUnit.MINUTES, new LinkedBlockingQueue<>(), new MyThreadFactory());
        executor.execute(ft2);
        executor.execute(ft1);
        // 等待线程T1执行结果
        System.out.println(ft1.get());
        System.out.println(ft2.get());
    }
}

// T1Task需要执行的任务：
// 洗水壶、烧开水、泡茶
class T1Task implements Callable<String> {
    FutureTask<String> ft2;

    // T1任务需要T2任务的FutureTask
    T1Task(FutureTask<String> ft2) {
        this.ft2 = ft2;
    }

    @Override
    public String call() throws Exception {
        System.out.println("T1:洗水壶...");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("T1:烧开水...");
        TimeUnit.SECONDS.sleep(15);
        // 获取T2线程的茶叶
        String tf = ft2.get();
        System.out.println("T1:拿到茶叶:" + tf);

        System.out.println("T1:泡茶...");
        return "上茶:" + tf;
    }
}

// T2Task需要执行的任务:
// 洗茶壶、洗茶杯、拿茶叶
class T2Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("T2:洗茶壶...");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("T2:洗茶杯...");
        TimeUnit.SECONDS.sleep(2);

        System.out.println("T2:拿茶叶...");
        TimeUnit.SECONDS.sleep(1);
        return "龙井";
    }
}
