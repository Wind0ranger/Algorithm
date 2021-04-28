package com.windranger.LeetCode;

import com.windranger.Common.TreeNode;

public class L938 {
    int res = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrder(root, low, high);
        return res;
    }

    private void inOrder(TreeNode root, int low, int high) {
        if (root != null) {
            inOrder(root.left, low, high);
            if (root.val >= low && root.val <= high) {
                res += root.val;
            }
            inOrder(root.right, low, high);
        }
    }

    public static void main(String[] args) {
        L938 l938 = new L938();
        TreeNode root = TreeNode.generate();
        System.out.println(l938.rangeSumBST(root, 7, 15));
    }
}
