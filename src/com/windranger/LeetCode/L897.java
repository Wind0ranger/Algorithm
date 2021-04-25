package com.windranger.LeetCode;

import com.windranger.Common.TreeNode;

public class L897 {
    TreeNode res = new TreeNode(-1);
    TreeNode next = res;

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return res.right;
    }

    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            next.right = new TreeNode(node.val);
            next = next.right;
            inOrder(node.right);
        }
    }


    public static void main(String[] args) {
        L897 l897 = new L897();
        TreeNode root = TreeNode.generate();
        TreeNode node = l897.increasingBST(root);
        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }
}
