package com.windranger.DesignPattern.Singleton;

public class LazyTest {
    public static void main(String[] args) {
        RunnableTest test = new RunnableTest();
        new Thread(test,"线程1").start();
        new Thread(test,"线程2").start();
        new Thread(test,"线程3").start();
        new Thread(test,"线程4").start();
        new Thread(test,"线程5").start();
        new Thread(test,"线程6").start();
        new Thread(test,"线程7").start();
    }

    static class RunnableTest implements Runnable {

        @Override
        public void run() {
            System.out.println(LazySingleton.getInstance());
        }
    }
}
