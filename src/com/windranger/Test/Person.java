package com.windranger.Test;

public class Person {
    int age;
    String name;

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
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a==b);
//        Person person = new Person();
//        person.setName("bb");
//        System.out.println(person.toString());
//        PersonCrossTest(person);
//        System.out.println(person.toString());
    }

    public static void PersonCrossTest(Person person) {
        person = new Person();
        person.setName("aa");
    }
}
