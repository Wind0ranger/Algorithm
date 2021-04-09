package com.windranger.LeetCode;

public class L154 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        L154 l154 = new L154();
        int[] nums = new int[]{2, 2, 2, 0, 1};
        System.out.println(l154.findMin(nums));
    }
}
