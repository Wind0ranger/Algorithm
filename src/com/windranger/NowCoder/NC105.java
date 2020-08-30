package com.windranger.NowCoder;

public class NC105 {
    public static void main(String[] args) {
        NC105 nc = new NC105();
        System.out.println(nc.upper_bound_(5, 4, new int[]{1, 2, 4, 4, 5}));
    }

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= v) {
                if (mid == 0 || a[mid - 1] < v) {
                    return mid + 1;
                } else {
                    right = mid;
                }
            } else {
                left = mid + 1;
            }
        }
        return n + 1;
    }
}
