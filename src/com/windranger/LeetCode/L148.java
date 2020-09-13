package com.windranger.LeetCode;

import com.windranger.Common.ListNode;

public class L148 {
    public static void main(String[] args) {
        L148 l = new L148();
        ListNode head = ListNode.generate();
        System.out.println(ListNode.Print(head));
        head = l.sortList(head);
        System.out.println(ListNode.Print(head));
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode node = new ListNode(0);
        ListNode root = node;
        // 合并链表
        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        node.next = left != null ? left : right;
        return root.next;
    }
}
