package com.windranger.DesignPattern.Singleton;

public class EnumSingleton {
    private enum Singleton {
        INSTANCE;

        private final EnumSingleton instance;

        Singleton() {
            instance = new EnumSingleton();
        }

        private EnumSingleton getInstance() {
            return instance;
        }
    }

    public static EnumSingleton getInstance() {

        return Singleton.INSTANCE.getInstance();
    }

}
