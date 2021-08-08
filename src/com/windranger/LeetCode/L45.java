package com.windranger.LeetCode;

public class L45 {
    public static void main(String[] args) {
        L45 l45 = new L45();
        int[] nums = {2, 2, 1, 1, 4};
        System.out.println(l45.jump(nums));
    }

    public int jump(int[] nums) {
        int res = 0, start = 0, end = 1;
        int maxPos = 0;
        while (end < nums.length) {
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, nums[i] + i);
            }
            start = end;
            end = maxPos + 1;
            res++;
        }
        return res;
    }
}
