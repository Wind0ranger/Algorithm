package com.windranger.Exception;

import java.io.*;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            tt();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private static void tt() throws ClassNotFoundException {
        try {
            test();
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }finally {
            System.out.println("--");
        }
    }
    private static void test() throws IOException {
//        FileInputStream file = new FileInputStream("ss");
//        int x = file.read();
        System.out.println("x");
    }

}
