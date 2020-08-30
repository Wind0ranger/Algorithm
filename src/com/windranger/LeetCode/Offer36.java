package com.windranger.LeetCode;

import com.windranger.Common.Node;

import java.util.*;

public class Offer36 {
    public static void main(String[] args) {
        Offer36 offer = new Offer36();
        Node node = offer.treeToDoublyList(Node.generate());
        System.out.println(node);
    }

    public Node treeToDoublyList(Node root) {
        // 1. 中序遍历
        List<Node> track = new LinkedList<>();
        order(root, track);
        if (track.size() < 1) {
            return root;
        }
        if (track.size() == 1) {
            root.left = root;
            root.right = root;
            return root;
        }
        root = track.get(0);
        Node prev = track.get(0);
        Node next = null;
        for (int i = 1; i < track.size(); i++) {
            next = track.get(i);
            prev.right = next;
            next.left = prev;
            prev = next;
        }
        next.right = root;
        root.left = next;
        return root;
    }

    private void order(Node root, List<Node> track) {
        if (root != null) {
            order(root.left, track);
            track.add(root);
            order(root.right, track);
        }
    }
}
