package com.windranger.LeetCode;

import java.util.Random;

public class L215 {

    public static void main(String[] args) {
        L215 l = new L215();
        System.out.println(l.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else if (q < index) {
            return quickSelect(nums, q + 1, r, index);
        } else {
            return quickSelect(nums, l, q - 1, index);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        Random random = new Random();
        swap(nums, (random.nextInt(r - l + 1) + l), r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
