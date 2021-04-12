package com.windranger.LeetCode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class L179 {
    public String largestNumber(int[] nums) {
        List<String> lists = new LinkedList<>();
        for (int num : nums) {
            lists.add(String.valueOf(num));
        }
        lists.sort((o1, o2) -> {
            long s1 = Long.parseLong(o1 + o2);
            long s2 = Long.parseLong(o2 + o1);
            return (int) (s2 - s1);
        });
        System.out.println(lists);
        StringBuilder builder = new StringBuilder();
        for (String list : lists) {
            builder.append(list);
        }
        String s = builder.toString().replaceAll("0", "");
        if (s.equals("")) {
            return "0";
        } else {
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        L179 l179 = new L179();
        int[] nums = new int[]{999999999, 999999998, 999999997};
        System.out.println(l179.largestNumber(nums));
    }
}
