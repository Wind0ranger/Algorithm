package com.windranger.Greek.Condition;


public class volatileTest {
    private static volatile int aa = 2;

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            int i = 1;
            while (i <= 52) {
                if (aa > 0) {
                    System.out.println(i);
                    i++;
                    aa--;
                } else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread b = new Thread(() -> {
            int i = 'A';
            while (i <= 'Z') {
                if (aa == 0) {
                    System.out.println((char) i);
                    i++;
                    aa = 2;
                } else {
                    try {
                        Thread.sleep(10);
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
