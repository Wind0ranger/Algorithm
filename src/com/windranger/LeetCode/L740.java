package com.windranger.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L740 {
    public static void main(String[] args) {
        L740 l740 = new L740();
        int[] nums = {1};
        System.out.println(l740.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxNum = 0;
        for (int val : nums) {
            maxNum = Math.max(maxNum, val);
        }
        int[] temps = new int[maxNum];
        for (int val : nums) {
            temps[val - 1] += val;
        }

        if (maxNum == 1) {
            return temps[0];
        } else {
            int n = temps.length;
            int[] res = new int[n];
            res[0] = temps[0];
            res[1] = Math.max(temps[0], temps[1]);
            for (int i = 2; i < n; i++) {
                res[i] = Math.max(res[i - 2] + temps[i], res[i - 1]);
            }
            return Math.max(res[n - 1], res[n - 2]);
        }
    }
}
