package com.windranger.LeetCode;

import java.util.HashSet;
import java.util.Scanner;

public class L79 {

    public static void main(String[] args) {
        L79 l = new L79();
        char[][] chars = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(l.exist(chars, "ABCEFSADEESE"));
//        System.out.println(l.exist(chars, "SEE"));
//        System.out.println(l.exist(chars, "ABCB"));
//        char[][] chars = {{'A', 'A'}};
//        System.out.println(l.exist(chars, "AAA"));
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    HashSet<String> set = new HashSet<>();
                    set.add(i + "," + j);
                    flag = hasWord(board, word, 1, i, j, set);
                    if (flag) {
                        break;
                    }
                }
            }
            if (flag) {
                break;
            }
        }
        return flag;
    }

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static boolean hasWord(char[][] nums, String s, int i, int x, int y, HashSet<String> set) {
        boolean flag = false;
        if (s.length() == i) {
            return true;
        }
        for (int[] d : dir) {
            int pX = x + d[0];
            int pY = y + d[1];
            String v = pX + "," + pY;
            if (set.contains(v) || pX < 0 || pY < 0 || pX >= nums.length || pY >= nums[0].length) {
                continue;
            }
            if (nums[pX][pY] == s.charAt(i)) {
                set.add(v);
                flag = hasWord(nums, s, i + 1, pX, pY, set);
                if (flag) {
                    return flag;
                } else {
                    set.remove(v);
                }
            }
        }
        return flag;
    }

}