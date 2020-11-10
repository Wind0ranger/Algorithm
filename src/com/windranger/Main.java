package com.windranger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 9390; i++) {
            for (int j = 0; j < 9390; j++) {
                if (1.05 * i + 1.01 * j == 9300) {
                    System.out.println("1:"+i + "," + j);
                }
                if (1.05 * i + 1.03 * j == 9300) {
                    System.out.println("2:"+i + "," + j);
                }
                if (1.03 * i + 1.01 * j == 9300) {
                    System.out.println("3:"+i + "," + j);
                }
            }
        }
    }
}