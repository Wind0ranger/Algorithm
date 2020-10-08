package com.windranger.LeetCode;

public class M0103 {
    public static void main(String[] args) {
        M0103 m = new M0103();
        System.out.println(m.replaceSpaces("Mr John Smith    ", 13));
    }

    public String replaceSpaces(String S, int length) {
        return S.substring(0, length).replace(" ", "%20");
    }
}
