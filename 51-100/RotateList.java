package com.myepark;

public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode last = head;
        int len = 1;

        // exception case
        if (head == null || head.next == null || k == 0)
            return head;

        // find ListNode size
        while (last.next != null) {
            last = last.next;
            len++;
        }

        // make optimize `k`
        k %= len;

        // rotate the list (loop with `len - k` because of opposite direction)
        for (int i = 0; i < len - k; i++) {
            last.next = head;
            head = head.next;
            last = last.next;
            last.next = null;
        }

        return head;
    }
}
