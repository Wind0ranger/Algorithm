package com.windranger.LeetCode;

import com.windranger.Common.TreeNode;

public class L783 {
    int pre = -1;
    int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        midOrder(root);
        return res;
    }

    public void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrder(node.left);
        if (pre == -1) {
            pre = node.val;
        } else {
            res = Math.min(res, node.val - pre);
            pre = node.val;
        }
        midOrder(node.right);
    }

    public static void main(String[] args) {
        L783 l783 = new L783();
        TreeNode generate = TreeNode.generate();
        System.out.println(l783.minDiffInBST(generate));
    }
}
