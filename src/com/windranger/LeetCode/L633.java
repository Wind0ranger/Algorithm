package com.windranger.LeetCode;

public class L633 {
    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int) Math.sqrt(c);
        while (l <= r) {
            int sum = l * l + r * r;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L633 l633 = new L633();
        System.out.println(l633.judgeSquareSum(2));
    }
}
