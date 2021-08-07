package com.windranger.LeetCode;

import java.util.Arrays;

public class L198 {
    public static void main(String[] args) {
        L198 l198 = new L198();
        int[] nums = {2, 1, 1, 2};
        System.out.println(l198.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if (n == 1) {
            return nums[0];
        } else {
            res[0] = nums[0];
            res[1] = Math.max(res[0], res[1]);
            for (int i = 2; i < n; i++) {
                res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
            }
            System.out.println(Arrays.toString(res));
            return Math.max(res[n - 1], res[n - 2]);
        }
    }
}
