package com.windranger.LeetCode;

import java.util.Arrays;

public class L53 {
    public static void main(String[] args) {
        L53 l53 = new L53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(l53.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            res = Math.max(res, dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        return res;
    }
}
