package com.windranger.Greek.Condition;

public class OddEvenPrinter {
    private static final Object monitor = new Object();
    private static int limit = 26;

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            int i = 1;
            while (i < limit * 2) {
                synchronized (monitor) {
                    System.out.println(i);
                    i++;
                    System.out.println(i);
                    i++;
                    monitor.notifyAll();
                    try {
                        monitor.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        Thread b = new Thread(() -> {
            char i = 'A';
            while (i < (limit + 'A')) {
                synchronized (monitor) {
                    System.out.println(i);
                    i++;
                    monitor.notifyAll();
                    try {
                        monitor.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        a.start();
        b.start();
        a.join();
        b.join();
    }
}
