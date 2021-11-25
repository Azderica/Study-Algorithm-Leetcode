package com.myepark;

public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] l1_vals = {9, 9, 9, 9, 9, 9, 9};
        int[] l2_vals = {9, 9, 9, 9};
        ListNode l1 = null, l2 = null;
        ListNode cur = null;


        l1 = new ListNode(l1_vals[0], null);
        cur = l1;
        for (int i = 1; i < l1_vals.length; i++) {
            cur.next = new ListNode(l1_vals[i], null);
            cur = cur.next;
        }

        l2 = new ListNode(l2_vals[0], null);
        cur = l2;
        for (int i = 1; i < l2_vals.length; i++) {
            cur.next = new ListNode(l2_vals[i], null);
            cur = cur.next;
        }

        ListNode res = null;
        res = addTwoNumbers(l1, l2);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println("\n");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, next = null;
        ListNode startResult = null;
        int temp = 0, val;

        while (l1 != null && l2 != null) {
            val = (l1.val + l2.val + temp) % 10;
            temp = (l1.val + l2.val + temp) / 10;
            next = new ListNode(val, null);

            if (result == null) {
                result = next;
                startResult = result;
            } else {
                result.next = next;
                result = result.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            val = (l1.val + temp) % 10;
            temp = (l1.val + temp) / 10;
            result.next = new ListNode(val, null);
            result = result.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            val = (l2.val + temp) % 10;
            temp = (l2.val + temp) / 10;
            result.next = new ListNode(val, null);
            result = result.next;
            l2 = l2.next;
        }
        if (temp > 0) {
            result.next = new ListNode(temp, null);
        }

        return startResult;
    }
}
