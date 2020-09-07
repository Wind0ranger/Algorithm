package com.windranger.DesignPattern.Singleton;

public class HungryTest {
    public static void main(String[] args) {
        //System.out.println(new HungrySingleton());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(HungrySingleton.getInstance());
            }
        });
        System.out.println(HungrySingleton.getInstance());
        thread.start();
    }
}
