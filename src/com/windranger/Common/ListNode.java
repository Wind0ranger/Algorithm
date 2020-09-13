package com.windranger.Common;


public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode generate() {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(-2);
        ListNode f = new ListNode(-3);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        return a;
    }

    public static String Print(ListNode node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val).append(",");
            node = node.next;
        }
        return builder.toString();
    }
}