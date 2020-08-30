package com.windranger.Common;

public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public static Node generate() {
        Node node = new Node(1);
//        Node a = new Node(1);
//        Node b = new Node(2);
//        Node c = new Node(3);
//        Node d = new Node(5);
//        node.left = b;
//        node.right = d;
//        b.left = a;
//        b.right = c;
        return node;
    }
};
