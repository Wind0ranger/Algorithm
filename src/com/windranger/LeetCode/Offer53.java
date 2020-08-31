package com.windranger.LeetCode;

import java.util.HashMap;

public class Offer53 {
    public static void main(String[] args) {
        Offer53 offer53 = new Offer53();
        offer53.search(new int[]{1, 2, 3, 4}, 2);
    }

    public int search(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], +1);
            }
        }
        return map.getOrDefault(target, 0);
    }
}
