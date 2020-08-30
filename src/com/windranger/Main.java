package com.windranger;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a = 8 + 4 + 2 + 1;
        int flag = 0;
        for (int i = 0; i < 32; i++) {
            if ((a & 1) == 1) {
                flag++;
            }
            a = a >> 1;
        }
        System.out.println(flag);
    }

}