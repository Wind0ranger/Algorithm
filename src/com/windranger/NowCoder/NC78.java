package com.windranger.NowCoder;

import com.windranger.Common.ListNode;

public class NC78 {
    public static void main(String[] args) {
        ListNode node = ListNode.generate();
        NC78 nc = new NC78();
        ListNode head = nc.ReverseList(node);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode res = new ListNode(-1);
        while (head != null) {
            ListNode temp = res.next;
            ListNode tempHead = head.next;
            res.next = head;
            head.next = temp;
            head = tempHead;
        }
        return res.next;
    }
}
