package com.windranger.LeetCode;

public class L28 {
    public int strStr(String haystack, String needle) {
        String temp = haystack.replace(needle, "*");
        System.out.println(temp);
        char[] chars = temp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
