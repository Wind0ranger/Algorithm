package com.windranger.DesignPattern.Singleton;

public class DoubleCheckSingleton {
    private DoubleCheckSingleton() {

    }

    public static volatile DoubleCheckSingleton instance;

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
