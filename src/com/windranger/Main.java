package com.windranger;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        backtrack(nums, new LinkedList<>(), 0);
        System.out.println(set.size());
    }

    static HashSet<String> set = new HashSet<>();

    private static void backtrack(int[] nums, LinkedList<Integer> track, int j) {
        if (!track.isEmpty() && track.size() <= nums.length) {
            if (check(track)) {
                set.add(track.toString());
            }
        }
        for (int i = j; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, track, i + 1);
            track.removeLast();
        }

    }

    private static boolean check(LinkedList<Integer> track) {
        long sum = 0;
        long mul = 1;
        for (Integer integer : track) {
            sum += integer;
            mul *= integer;
        }
        return sum > mul;
    }
}