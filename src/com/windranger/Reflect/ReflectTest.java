package com.windranger.Reflect;

import java.lang.reflect.Modifier;

public class ReflectTest {
    public static void main(String[] args) {
        Class c;
        try {
            c = Class.forName("com.windranger.Reflect.UserBean");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("\n--------------获取类的所有信息----------------------\n");

        // 获取类的修饰符，public private...
        int mod = c.getModifiers();
        String modifier = Modifier.toString(mod);
        System.out.println("modifier       : " + modifier);

        // 获取父类
        Class superClass = c.getSuperclass();
        String superClassName = superClass.getName();
        System.out.println("superClassName : " + superClassName);


    }
}
