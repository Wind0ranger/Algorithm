package com.windranger.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class L1206 {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();

        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
//        boolean search = skiplist.search(0);
//        assert !search;
        skiplist.add(4);
        boolean search1 = skiplist.search(1);
        assert search1;
//        skiplist.erase(0);    // 返回 false，0 不在跳表中
//        skiplist.erase(1);    // 返回 true
//        skiplist.search(1);   // 返回 false，1 已被擦除
    }
}

class Skiplist {

    Node head = new Node(null, null, 0);

    public boolean search(int target) {
        // 先往右再往下，缩小区间，套路都是这个套路
        for (Node p = head; p != null; p = p.down) {
            while (p.right != null && p.right.val < target) {
                p = p.right;
            }
            if (p.right != null && p.right.val == target) {
                return true;
            }
        }
        return false;
    }

    Random rand = new Random();

    // 2^64 已经相当大了
    Node[] stack = new Node[64];

    public void add(int num) {
        int lv = -1;
        for (Node p = head; p != null; p = p.down) {
            while (p.right != null && p.right.val < num) {
                p = p.right;
            }
            stack[++lv] = p;
        }
        boolean insertUp = true;
        Node downNode = null;
        while (insertUp && lv >= 0) {
            Node insert = stack[lv--];
            insert.right = new Node(insert.right, downNode, num);
            downNode = insert.right;
            insertUp = (rand.nextInt() & 1) == 0;
        }
        if (insertUp) {
            head = new Node(new Node(null, downNode, num), head, 0);
        }
    }

    public boolean erase(int num) {
        boolean exists = false;
        for (Node p = head; p != null; p = p.down) {
            while (p.right != null && p.right.val < num) {
                p = p.right;
            }
            if (p.right != null && p.right.val <= num) {
                exists = true;
                p.right = p.right.right;
            }
        }
        return exists;
    }

    static class Node {
        int val;
        Node right, down;

        public Node(Node r, Node d, int val) {
            right = r;
            down = d;
            this.val = val;
        }
    }
}