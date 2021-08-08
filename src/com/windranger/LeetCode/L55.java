package com.windranger.LeetCode;

public class L55 {
    public static void main(String[] args) {
        L55 l55 = new L55();
        int[] nums = {2,3,1,1,4};
        System.out.println(l55.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] res = new boolean[n];
        res[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int r = nums[i];
            if (res[i]) {
                for (int j = 0; j <= r; j++) {
                    if (i + j < n) {
                        res[j + i] = true;
                    }
                }
            }
        }
        return res[n - 1];
    }
}
