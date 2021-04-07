package com.windranger.LeetCode;

import java.util.Arrays;

public class L81 {
    public boolean search(int[] nums, int target) {
        int spilt = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                spilt = i;
                break;
            }
        }
        return spilt != -1;
    }

    public boolean isOrder(int[] nums, int begin, int end) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, begin, end)));
        int len = end - begin;
        boolean flag = true;
        int slow = begin, fast = begin + 1;
        while (slow < len && fast < len) {
            if (nums[slow] > nums[fast]) {
                flag = false;
                break;
            }
            slow++;
            fast++;
        }
        return flag;
    }


    public static void main(String[] args) {
        L81 l81 = new L81();
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        //System.out.println(nums.length);
        System.out.println(l81.search(nums, 13));
    }


}
