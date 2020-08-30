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
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(3);
        TreeNode g = new TreeNode(1);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        d.left = f;
        d.right = g;
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
