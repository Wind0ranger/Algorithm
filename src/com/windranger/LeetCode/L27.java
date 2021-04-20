package com.windranger.LeetCode;

import java.util.Arrays;

public class L27 {
    public int removeElement(int[] nums, int val) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = Integer.MIN_VALUE;
                res--;
            }
        }
        System.out.println(Arrays.toString(nums));
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != Integer.MIN_VALUE) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        L27 l27 = new L27();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(l27.removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}
