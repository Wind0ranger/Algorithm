package com.windranger.LeetCode;

import com.windranger.Common.ListNode;

public class L141 {
    public static void main(String[] args) {
        L141 l = new L141();
        System.out.println(l.hasCycle(generate()));
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = null;
        if (slow != null && slow.next != null) {
            fast = head.next.next;
        }
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static ListNode generate() {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = a;
        return a;
    }
}
