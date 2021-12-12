package com.myepark.leetcode.from1to50;

public class SwapNodesInPairs {
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

    public static ListNode input(int[] input) {
        if (input.length == 0)
            return null;
        ListNode head = new ListNode(input[0], null);
        ListNode cur = head;
        for (int i = 1; i < input.length; i++) {
            cur.next = new ListNode(input[i], null);
            cur = cur.next;
        }
        return head;
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
        output(swapPairs(input(new int[]{1, 2, 3, 4})));
        output(swapPairs(input(new int[]{})));
        output(swapPairs(input(new int[]{1})));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head.next;
        ListNode slow = head;
        int tmp;


        tmp = fast.val;
        fast.val = slow.val;
        slow.val = tmp;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next.next;

            // swap
            tmp = fast.val;
            fast.val = slow.val;
            slow.val = tmp;
        }

        return head;
    }
}
