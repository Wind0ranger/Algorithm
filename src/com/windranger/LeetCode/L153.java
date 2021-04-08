package com.windranger.LeetCode;

public class L153 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m+1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        L153 l153 = new L153();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        System.out.println(l153.findMin(nums));
    }
}
