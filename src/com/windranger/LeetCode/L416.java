package com.windranger.LeetCode;

import java.util.Arrays;

public class L416 {
    public static void main(String[] args) {
        L416 l = new L416();
        int[] nums = {1, 5, 11, 5};
        System.out.println(l.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 0) {
            int h = sum / 2;

        }
        return false;
    }
}
