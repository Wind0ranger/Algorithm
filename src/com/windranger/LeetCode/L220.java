package com.windranger.LeetCode;

public class L220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t &&
                        Math.abs(i - j) <= k) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        L220 l220 = new L220();
        int[] nums = new int[]{-2147483648,2147483647};
        int k = 1;
        int t = 1;
        boolean b = l220.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(b);
    }
}
