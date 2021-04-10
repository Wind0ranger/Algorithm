package com.windranger.LeetCode;

public class L263 {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] nums = {2, 3, 5};
        for (int num : nums) {
            while (n % num == 0) {
                n = n / num;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        L263 l263 = new L263();
        System.out.println(l263.isUgly(6));
    }
}
