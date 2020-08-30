package com.windranger.LeetCode;


import com.windranger.Common.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Offer37 {
    public static void main(String[] args) {
        TreeNode node = TreeNode.generate();
        System.out.println(TreeNode.order(node, new LinkedList<>()));
        Offer37 offer = new Offer37();
        String res = offer.serialize(node);
        System.out.println(res);
        TreeNode r = offer.deserialize(res);
        System.out.println(TreeNode.order(r, new LinkedList<>()));

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode temp = deque.pop();
            if (temp != null) {
                builder.append(temp.val).append(",");
                deque.add(temp.left);
                deque.add(temp.right);
            } else {
                deque.add(null);
                deque.add(null);
                builder.append("null,");
            }
            if (breakContinue(deque)) {
                break;
            }
        }
        builder.delete(builder.length() - 1, builder.length()).append("]");
        return builder.toString();
    }

    private boolean breakContinue(Deque<TreeNode> deque) {
        for (TreeNode treeNode : deque) {
            if (treeNode != null) {
                return false;
            }
        }
        return true;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.substring(1, data.length() - 1).split(",");
        TreeNode[] list = new TreeNode[res.length];
        for (int i = 0; i < res.length; i++) {
            if ("null".equals(res[i])) {
                list[i] = null;
            } else {
                list[i] = new TreeNode(Integer.parseInt(res[i]));
            }
        }
        for (int i = 0; i < res.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < res.length && list[i] != null) {
                list[i].left = list[left];
            }
            if (right < res.length && list[i] != null) {
                list[i].right = list[right];
            }
        }
        return list[0];
    }
}
