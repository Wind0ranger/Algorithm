package com.windranger;


import java.util.*;

public class Main {
    private static int sum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Node> hashMap = new HashMap<>();
        int[][] array = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            int nodeId = scanner.nextInt();
            int value = scanner.nextInt();
            Node temp = new Node(nodeId, value);
            hashMap.put(nodeId, temp);
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            array[i][0] = left;
            array[i][1] = right;
        }
        for (int i = 0; i < n; i++) {
            Node node = hashMap.get(i + 1);
            if (array[i][0] != -1) {
                node.left = hashMap.get(array[i][0]);
            }
            if (array[i][1] != -1) {
                node.right = hashMap.get(array[i][1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            Node root = hashMap.get(i);
            maxGain(root, 0);
        }
        System.out.println(sum);
    }

    public static int maxGain(Node root, int prev) {
        if (root == null) {
            return 0;
        }
        int left = root.value ^ prev;
        int right = root.value ^ prev;
        if (root.left != null) {
            left = maxGain(root.left, left);
        }
        if (root.right != null) {
            right = maxGain(root.right, right);
        }
        int res = Math.max(left, right);
        sum = Math.max(sum, res);
        return res;
    }

    static class Node {
        int nodeid;
        int value;
        Node left = null;
        Node right = null;

        public Node(int nodeid, int value) {
            this.nodeid = nodeid;
            this.value = value;
        }
    }
}

