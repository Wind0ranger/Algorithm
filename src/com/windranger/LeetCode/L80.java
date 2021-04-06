package com.windranger.LeetCode;

public class L80 {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        int n = 0;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                int len = Math.min(fast - slow, 2);
                n += len;
                for (int i = slow + 2; i < fast; i++) {
                    nums[i] = Integer.MIN_VALUE;
                }
                slow = fast;
            }
        }
        int len = Math.min(fast - slow, 2);
        n += len;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                nums[j] = nums[i];
                j++;
            }
        }
        return n;
    }
}
