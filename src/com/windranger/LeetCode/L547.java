package com.windranger.LeetCode;

import java.util.*;

public class L547 {
    public static void main(String[] args) {
        L547 l = new L547();
        int[][] nums = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        System.out.println(l.findCircleNum(nums));
    }

    private int findCircleNum(int[][] nums) {
        int n = nums.length;
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && nums[i][j] == 1) {
                    union(parents, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(parents));
        int count = 0;
        for (int parent : parents) {
            if (parent == -1) {
                count++;
            }
        }
        return count;
    }

    private void union(int[] parents, int i, int j) {
        int x = find(parents, i);
        int y = find(parents, j);
        if (x != y) {
            parents[x] = y;
        }
    }

    private int find(int[] parents, int i) {
        if (parents[i] == -1) {
            return i;
        }
        return find(parents, parents[i]);
    }


}
