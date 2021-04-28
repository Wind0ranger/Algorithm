package com.windranger.Common;

import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode generate() {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(18);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        return a;
    }

    public static List<Integer> order(TreeNode node, List<Integer> list) {
        if (node != null) {
            order(node.left, list);
            list.add(node.val);
            order(node.right, list);
        }
        return list;
    }
}
