package com.windranger;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int temp = getIndex(i, k, n, nums);
            builder.append(temp).append(" ");
        }
        System.out.println(builder.toString());

    }

    private static int getIndex(int i, int k, int n, int[] nums) {
        List<Integer> list = new LinkedList<>();
        if (k > 0) {
            for (int j = 1; j <= k; j++) {
                int index = i - j;
                while (index < 0) {
                    index = index + n;
                }
                list.add(index);
            }
        } else {
            k = -k;
            for (int j = 1; j <= k; j++) {
                int index = i + j;
                while (index >= n) {
                    index = index - n;
                }
                list.add(index);
            }
        }
        int res = 0;
        for (Integer j : list) {
            if (nums[j] % 2 == 0) {
                res += 0;
            } else {
                res += nums[j];
            }
        }
        return res;
    }
}