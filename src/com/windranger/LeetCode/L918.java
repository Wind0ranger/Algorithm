package com.windranger.LeetCode;

public class L918 {
    public static void main(String[] args) {
        L918 l918 = new L918();
        int[] nums = {5, -3, 5};
        System.out.println(l918.maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int min = 0;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
            sum += nums[i];
        }
        for (int i = 1; i < n - 1; i++) {
            dp[i] = Math.min(nums[i], dp[i - 1] + nums[i]);
            min = Math.max(min, dp[i]);
        }
        return Math.max(sum - min, max);

    }
}
