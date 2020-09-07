package com.windranger.DesignPattern.Singleton;

public class StaticSingleton {
    private StaticSingleton() {
    }

    public static StaticSingleton getInstance() {
        return StaticClass.instance;
    }

    private static class StaticClass {
        private static final StaticSingleton instance = new StaticSingleton();
    }
}
