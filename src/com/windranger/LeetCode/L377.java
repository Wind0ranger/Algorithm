package com.windranger.LeetCode;

public class L377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= target) {
                    dp[i] = dp[i] + dp[num - target];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        L377 l377 = new L377();
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        int i = l377.combinationSum4(nums, target);
        System.out.println(i);
    }
}
