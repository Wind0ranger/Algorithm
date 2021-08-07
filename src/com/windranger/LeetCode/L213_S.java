package com.windranger.LeetCode;

public class L213_S {
    public static void main(String[] args) {
        L213_S l213S = new L213_S();
        int[] nums = {1, 2, 3, 1};
        System.out.println(l213S.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else {
            return Math.max(robSub(nums, 0, n - 1), robSub(nums, 1, n));
        }
    }

    private int robSub(int[] nums, int begin, int end) {
        int n = end - begin;
        if (n == 1) {
            return nums[begin];
        } else {
            int[] res = new int[n];
            res[0] = nums[begin];
            res[1] = Math.max(nums[begin], nums[begin + 1]);
            for (int i = 2; i < n; i++) {
                res[i] = Math.max(res[i - 2] + nums[i+begin], res[i - 1]);
            }
            return Math.max(res[n - 1], res[n - 2]);
        }
    }
}
