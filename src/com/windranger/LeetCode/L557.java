package com.windranger.LeetCode;

public class L557 {
    public static void main(String[] args) {
        L557 l = new L557();
        System.out.println(l.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String t : ss) {
            for (int i = t.length() - 1; i >= 0; i--) {
                res.append(t.charAt(i));
            }
            res.append(" ");
        }
        return res.substring(0, res.length() - 1);
    }
}
