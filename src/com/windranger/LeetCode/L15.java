package com.windranger.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class L15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        L15 l = new L15();
        System.out.println(l.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new LinkedList<>();
            int a = nums[i];
            // 双指针
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int s = nums[l] + nums[r];
                if (s + a == 0) {
                    list.add(a);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    String ss = a + "," + nums[l] + "," + nums[r];
                    if (!set.contains(ss)) {
                        res.add(new LinkedList<>(list));
                        set.add(ss);
                    }
                    list = new LinkedList<>();
                    l++;
                    r--;
                }
                if (s + a < 0) {
                    l++;
                }
                if (s + a > 0) {
                    r--;
                }
            }
        }
        return res;
    }
}
