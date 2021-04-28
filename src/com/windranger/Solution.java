package com.windranger;


import java.util.*;

public class Solution {
    //    public String genStr(String command) {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < command.length(); i += 2) {
//            char c = command.charAt(i);
//            int n = command.charAt(i + 1) - '0';
//            for (int j = 0; j < n; j++) {
//                builder.append(c);
//            }
//        }
//        return builder.toString();
//    }
    public int getMaxNeighbour(String[] value_matrix, int row, int col) {
        int col_len = value_matrix[0].split(",").length;
        int row_len = value_matrix.length;
        int[][] matrix = new int[row_len][col_len];
        for (int i = 0; i < value_matrix.length; i++) {
            String[] split = value_matrix[i].split(",");
            for (int j = 0; j < split.length; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }
        int l_row = Math.max(row - 1, 0);
        int r_row = Math.min(row + 1, row_len);
        int l_col = Math.max(col - 1, 0);
        int r_col = Math.min(col + 1, col_len);
        int max = 0;
        for (int i = l_row; i < r_row; i++) {
            for (int j = l_col; j < r_col; j++) {
                if (i != row && j != col) {
                    max = Math.max(matrix[i][j], max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] value_matrix = new String[]{"6,2,8,6,7", "5,8,1,4,9", "1,3,5,2,1", "4,1,1,4,1", "3,6,5,2,1"};
        System.out.println(solution.getMaxNeighbour(value_matrix, 2, 2));
    }

}