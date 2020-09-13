package com.windranger;

import java.util.*;

//-1 0 1 2 -1 -4
public class Main {
    static HashSet<String> res = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split("\\s+");
        int[] nums = new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ss[i].replace(" ", ""));
        }
        Arrays.sort(nums);
        backTrack(nums, 0, new LinkedList<>(), 0);
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static void backTrack(int[] nums, int index, LinkedList<Integer> track, int sum) {
        if (track.size() == 3) {
            if (sum == 0) {
                StringBuilder builder = new StringBuilder();
                for (Integer integer : track) {
                    builder.append(integer).append(" ");
                }
                res.add(builder.subSequence(0, builder.length() - 1).toString());
            }
            return;
        }
        for (int j = index; j < nums.length; j++) {
            track.add(nums[j]);
            sum += nums[j];
            backTrack(nums, j + 1, track, sum);
            track.removeLast();
            sum -= nums[j];
        }
    }
}
