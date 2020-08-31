package com.windranger;


public class Solution {

    public static void main(String[] args) {
        int num = test();
        System.out.println(num);
    }

    private static int test() {
        try {
            System.out.println("t");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("e");
            return 0;
        } finally {
            System.out.println("f");
            return 1;
        }
    }

}
