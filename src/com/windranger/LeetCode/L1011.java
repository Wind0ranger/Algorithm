package com.windranger.LeetCode;

import java.util.Arrays;

public class L1011 {
    public int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).sum();
        while (l < r) {
            int mid = (l + r) / 2;
            int needDay = 1, curWeight = 0;
            for (int weight : weights) {
                if (curWeight + weight > mid) {
                    needDay++;
                    curWeight = 0;
                }
                curWeight += weight;
            }
            if (needDay <= D) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        L1011 l1011 = new L1011();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        int i = l1011.shipWithinDays(nums, D);
        System.out.println(i);
    }

}
