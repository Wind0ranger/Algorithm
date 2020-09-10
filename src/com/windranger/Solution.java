package com.windranger;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Node node = Node.generate();
        AddOne(node);
    }

    private static void AddOne(Node node) {
        // 1. 反转链表
        node = reverse(node);
        // 2. 加一
        node = addOne(node);
        // 3. 反转
        node = reverse(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static Node addOne(Node node) {
        Node root = new Node(0);
        root.next = node;
        int flag = 1;
        while (node != null && flag != 0) {
            int val = node.val + flag;
            if (val > 9) {
                node.val = val % 10;
                flag = 1;
                if (node.next == null) {
                    node.next = new Node(flag);
                    flag = 0;
                } else {
                    node = node.next;
                }
            } else {
                node.val = val;
                flag = 0;
            }
        }
        return root.next;

    }

    private static Node reverse(Node node) {
        Node root = new Node(0);
        root.next = node;
        while (node.next != null) {
            Node next = node.next;
            Node temp = root.next;
            root.next = next;
            node.next = next.next;
            next.next = temp;
        }
        return root.next;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public static Node generate() {
            Node node = new Node(9);
            Node a = new Node(9);
            Node b = new Node(9);
            node.next = a;
            a.next = b;
            return node;
        }


    }

}