package com.windranger.LeetCode;

public class L215 {

    public static void main(String[] args) {
        L215 l = new L215();
        System.out.println(l.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        int q = partition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else if (q > index) {
            return quickSelect(nums, l, q - 1, index);
        } else {
            return quickSelect(nums, q + 1, r, index);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[r], k = l - 1;
        for (int i = l; i < r; i++) {
            if (nums[i] < x) {
                swap(nums, i, ++k);
            }
        }
        swap(nums, ++k, r);
        return k;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
