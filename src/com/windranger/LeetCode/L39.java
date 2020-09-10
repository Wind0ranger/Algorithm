package com.windranger.LeetCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class L39 {
    public static void main(String[] args) {
        L39 l = new L39();
        l.combinationSum(new int[]{2, 3, 5}, 8);
    }

    static List<List<Integer>> list = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, new LinkedList<>(), 0, new HashSet<String>());
        System.out.println(list);
        return list;
    }


    private void backtrack(int[] candidates, int target, LinkedList<Integer> track, int sum, HashSet<String> set) {
        if (sum == target) {
            List<Integer> temp = new LinkedList<>(track);
            Collections.sort(temp);
            if (!set.contains(temp.toString())) {
                set.add(temp.toString());
                list.add(temp);
            }
            return;
        }
        for (int candidate : candidates) {
            track.add(candidate);
            sum += candidate;
            if (sum <= target) {
                backtrack(candidates, target, track, sum, set);
            }
            sum -= candidate;
            track.removeLast();
        }
    }
}
