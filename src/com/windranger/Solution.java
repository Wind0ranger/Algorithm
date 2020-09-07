package com.windranger;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberofprize(9, 3, 3));
//        System.out.println(solution.getHouses(2, new int[]{-1, 4, 5, 2, 4, 2}));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回能交换奖品的最大数量
     *
     * @param a int整型
     * @param b int整型
     * @param c int整型
     * @return int整型
     */
    public int numberofprize(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int middle = getMiddle(a, b, c);
        while ((max - min) >= 2) {
            a = max - 2;
            b = middle;
            c = min + 1;
            min = Math.min(a, Math.min(b, c));
            max = Math.max(a, Math.max(b, c));
            middle = getMiddle(a, b, c);
        }
        return min;
    }

    private int getMiddle(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                return Math.max(b, c);
            } else {
                return b;
            }
        } else {
            if (b > c) {
                return Math.max(a, c);
            } else {
                return b;
            }
        }
    }

}