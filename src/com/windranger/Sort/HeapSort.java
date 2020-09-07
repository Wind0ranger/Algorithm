package com.windranger.Sort;

import java.util.Arrays;
import java.util.List;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = Common.generate();
//        int[] nums = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        for (int i = nums.length / 2; i >= 0; i--) {
            heapSort.heap(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            heapSort.heap(nums, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
        }
        System.out.println(Arrays.toString(nums));
    }

    private void heap(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int lager = i;
        if (left < len && nums[left] > nums[lager]) {
            lager = left;
        }
        if (right < len && nums[right] > nums[lager]) {
            lager = right;
        }
        if (lager != i) {
            swap(nums, i, lager);
            heap(nums, lager, len);
        }
    }

    private static void swap(int[] nums, int i, int lager) {
        int temp = nums[i];
        nums[i] = nums[lager];
        nums[lager] = temp;
    }

}
