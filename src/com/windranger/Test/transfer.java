package com.windranger.Test;

import java.util.Arrays;

public class transfer {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        test(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(nums.getClass().getName());
    }

    private static void test(int[] nums) {
        nums[0] = 0;
    }
}
