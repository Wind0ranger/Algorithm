package com.windranger.Basic;

public class CompareTest {
    public static void main(String[] args) {

    }
}

class UserInfo implements Comparable<UserInfo> {
    private int age;
    private String name;

    public UserInfo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.age + "," + this.name;
    }

    @Override
    public int compareTo(UserInfo o) {
        //如果年龄相同，则比较userid，也可以直接  return this.age-o.age;
        return this.age - o.age;
    }

}