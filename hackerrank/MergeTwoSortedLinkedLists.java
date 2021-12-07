package com.myepark.hackerrank;

public class MergeTwoSortedLinkedLists {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(data) {
            this.data = data;
            this.next = null;
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode result = null;
        SinglyLinkedListNode temp = null;

        // find exception case
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        if (head1.data < head2.data) {
            temp = new SinglyLinkedListNode(head1.data);
            head1 = head1.next;
        } else {
            temp = new SinglyLinkedListNode(head2.data);
            head2 = head2.next;
        }
        result = temp;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = new SinglyLinkedListNode(head1.data);
                temp = temp.next;
                head1 = head1.next;
            } else {
                temp.next = new SinglyLinkedListNode(head2.data);
                temp = temp.next;
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            temp.next = new SinglyLinkedListNode(head1.data);
            temp = temp.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            temp.next = new SinglyLinkedListNode(head2.data);
            temp = temp.next;
            head2 = head2.next;
        }
        return result;
    }
}
