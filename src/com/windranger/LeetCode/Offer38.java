package com.windranger.LeetCode;

import java.util.*;

public class Offer38 {
    public static void main(String[] args) {
        Offer38 offer = new Offer38();
        String[] res = offer.permutation("abb");
        System.out.println(Arrays.toString(res));
    }

    List<String> res = new LinkedList<>();

    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        backtrack(arr, new LinkedList<>(), new boolean[arr.length]);
        return res.toArray(new String[0]);
    }

    private void backtrack(char[] arr, LinkedList<Character> track, boolean[] v) {
        if (track.size() == arr.length) {
            StringBuilder builder = new StringBuilder();
            for (Character c : track) {
                builder.append(c);
            }
            res.add(builder.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (v[i]) {
                continue;
            }
            if (i > 0 && arr[i] == arr[i - 1] && v[i - 1]) {
                continue;
            }
            track.add(arr[i]);
            v[i] = true;
            backtrack(arr, track, v);
            track.removeLast();
            v[i] = false;
        }
    }
}
