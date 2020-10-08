package com.windranger.LeetCode;

public class L344 {
    public static void main(String[] args) {
        L344 l = new L344();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        l.reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            swap(s, i, len - 1 - i);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
