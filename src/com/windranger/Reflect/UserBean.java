package com.windranger.Reflect;

public class UserBean {
    private String mName;
    private int mAge;
    private String mVersion = "1.0";

    public UserBean() {
        System.out.println("    UserBean Constructor1 called!");
    }

    public UserBean(String name, int age) {
        System.out.println("    UserBean Constructor2 called!");
        init(name, age);
    }

    public void setName(String name) {
        mName = name;
        System.out.println("    UserBean setName() done");
    }

    public String getName() {
        return mName;
    }

    public void setAge(int age) {
        mAge = age;
        System.out.println("    UserBean setAge() done");
    }

    public int getAge() {
        return mAge;
    }

    private void init(String name, int age) {
        mName = name;
        mAge = age;
    }

    public void printVersion() {
        System.out.println("    UserBean VERSION: " + mVersion);
    }

    public void printName() {
        System.out.println("    UserBean mName [" + mName + "]");
    }

    public void printAge() {
        System.out.println("    UserBean mAge [" + mAge + "]");
    }

    private void printUserInfo() {
        System.out.println("    UserBean mName [" + mName + "] " + "mAge [" + mAge + "]");
    }
}