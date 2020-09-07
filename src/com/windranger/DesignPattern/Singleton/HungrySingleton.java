package com.windranger.DesignPattern.Singleton;

public class HungrySingleton {
    public static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
