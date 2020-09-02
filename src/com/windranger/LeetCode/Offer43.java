package com.windranger.LeetCode;

public class Offer43 {
    public static void main(String[] args) {
        Offer43 offer = new Offer43();
        System.out.println(offer.findNthDigit(3));
    }

    public int findNthDigit(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (builder.length() <= n) {
                builder.append(i);
            }else{
                break;
            }
        }
        return builder.toString().charAt(n) - '0';
    }
}
