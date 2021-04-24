package com.windranger.LeetCode;

import java.util.LinkedList;
import java.util.List;

public class L91 {
    List<List<String>> result = new LinkedList<>();

    public int numDecodings(String s) {
        LinkedList<String> track = new LinkedList<>();
        backtrack(s, track, 0);
        for (List<String> strings : result) {
            System.out.println(strings);
        }
        return result.size();
    }

    private void backtrack(String s, LinkedList<String> track, int n) {
        if (s.length() == n) {
            result.add(track);
            return;
        }
        for (int i = n; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                track.add(s.substring(i, j));
                backtrack(s, track, j);
                track.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        L91 l91 = new L91();
        l91.numDecodings("223");
    }
}
