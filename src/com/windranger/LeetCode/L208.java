package com.windranger.LeetCode;

public class L208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));//true
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));//true
        trie.insert("app");
        System.out.println(trie.search("app"));//true
    }
}

class Trie {
    public Trie[] alphabets = new Trie[26];
    public boolean isEnd = false;

    public void insert(String word) {
        Trie temp = this;
        for (char c : word.toCharArray()) {
            if (temp.alphabets[c - 'a'] == null) {
                temp.alphabets[c - 'a'] = new Trie();
            }
            temp = temp.alphabets[c - 'a'];
        }
        temp.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie temp = this;
        for (char c : word.toCharArray()) {
            if (temp.alphabets[c - 'a'] != null) {
                temp = temp.alphabets[c - 'a'];
            } else {
                return false;
            }
        }
        return temp.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie temp = this;
        for (char c : prefix.toCharArray()) {
            if (temp.alphabets[c - 'a'] != null) {
                temp = temp.alphabets[c - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}