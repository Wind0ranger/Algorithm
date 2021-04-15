package com.windranger.LeetCode;

public class L213 {
    public int rob(int[] nums) {
        return Math.max(robDp(nums, 0, nums.length - 1),
                robDp(nums, 1, nums.length));
    }

    private int robDp(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        L213 l213 = new L213();
        int[] nums = new int[]{1, 3, 1, 3, 100};
        int rob = l213.rob(nums);
        System.out.println(rob);
    }
}
