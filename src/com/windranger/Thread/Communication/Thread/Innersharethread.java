package com.windranger.Thread.Communication.Thread;

// 内部类的共享变量
public class Innersharethread {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        new Thread(mythread).start();
        new Thread(mythread).start();
        new Thread(mythread).start();
        new Thread(mythread).start();
    }

    static class Mythread implements Runnable {
        int index = 0;

        @Override
        public synchronized void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "is running and the index is " + index++);
            }
        }
    }



}
