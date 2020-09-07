package com.windranger.DesignPattern.Singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class DoubleTest {
    public static void main(String[] args) {
        CallableThreadTest c = new CallableThreadTest();
        for (int i = 0; i < 20; i++) {
            FutureTask<Integer> task = new FutureTask<>(c);
            new Thread(task, "线程" + i).start();
        }
    }

    public static class CallableThreadTest implements Callable<Integer> {

        @Override
        public Integer call() {
            System.out.println(Thread.currentThread().getName() +
                    ":" + DoubleCheckSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() +
                    ":" + DoubleCheckSingleton.getInstance());
            return 1;
        }
    }
}
