package com.windranger.LeetCode;

import java.util.*;

public class L212 {
    public static void main(String[] args) {
        L212 l = new L212();
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        System.out.println(l.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        // 1. 建立字典树
        return null;
    }
}
