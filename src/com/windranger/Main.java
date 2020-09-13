package com.windranger;

import java.util.*;
//
//3
//Gogo ao

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        StringBuilder builder = new StringBuilder();
        if (n == 0 || n == 1) {
            System.out.println(s);
        } else {
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < s.length(); i += n) {
                if (i + n > s.length()) {
                    b.append(s.substring(i)).reverse();
                } else {
                    b.append(s, i, i + n).reverse();
                }
                builder.append(b);
                b.setLength(0);
            }

            System.out.println(builder.toString());
        }
    }

    private static String reverse(String substring) {
        StringBuilder builder = new StringBuilder();
        for (int i = substring.length() - 1; i >= 0; i--) {
            builder.append(substring.charAt(i));
        }
        return builder.toString();
    }

}
