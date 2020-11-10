package com.windranger.LeetCode;

import java.util.Arrays;

public class L31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        L31 l = new L31();
//        int[] nums = {1, 2, 3, 8, 5, 7, 6, 4};
        int[] nums = {5, 4, 7, 5, 3, 2};

        l.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
