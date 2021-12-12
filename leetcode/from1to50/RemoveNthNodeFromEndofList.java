package com.myepark.leetcode.from1to50;

public class RemoveNthNodeFromEndofList {
    static class ListNode {
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

    public static ListNode input(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode res = new ListNode(arr[0], null);
        ListNode cur = res;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i], null);
            cur = cur.next;
        }
        return res;
    }

    public static void output(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        output(removeNthFromEnd(input(new int[]{1, 2, 3, 4, 5}), 2));
        output(removeNthFromEnd(input(new int[]{1}), 1));
        output(removeNthFromEnd(input(new int[]{1, 2}), 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null) return null;

        // fast is more than n ahead of slow.
        for (int i = 0; i < n; i++)
            fast = fast.next;

        // if first node
        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}
