package com.windranger;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        test(s);
    }

    private static void test(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            for (int j = i; j < s.length(); j++) {
                if (a == s.charAt(j)) {
                    dp[i] = j - i + 1;
                    max = Math.max(dp[i], max);
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                System.out.println(s.charAt(i) + ":" + dp[i]);
            }
        }
    }
}

//abcaakjbb