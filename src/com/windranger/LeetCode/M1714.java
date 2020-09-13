package com.windranger.LeetCode;

import java.util.Arrays;
import java.util.Random;

public class M1714 {
    public static void main(String[] args) {
        M1714 m = new M1714();
        System.out.println(Arrays.toString(m.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 3)));
        System.out.println(Arrays.toString(m.smallestK(new int[]{1, 2, 3}, 0)));
        System.out.println(Arrays.toString(m.smallestK(new int[]{}, 0)));
    }

    Random random = new Random();

    public int[] smallestK(int[] arr, int k) {
        if (arr.length==0||k==0){
            return new int[]{};
        }
        quickSelect(arr, 0, arr.length - 1, k);
        int[] nums = new int[k];
        if (k >= 0) {
            System.arraycopy(arr, 0, nums, 0, k);
        }
        return nums;
    }

    private int[] quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums;
        } else if (q < index) {
            return quickSelect(nums, q + 1, r, index);
        } else {
            return quickSelect(nums, l, q - 1, index);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int q = random.nextInt(r - l + 1) + l;
        swap(nums, q, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] < x) {
                swap(nums, j, ++i);
            }
        }
        swap(nums, r, ++i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
