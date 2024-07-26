package com.code.java.practise.package1;

import com.code.java.practise.utils.ListNode;

public class Question86 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(4);
        head.next = listNode;
        ListNode listNode1 = new ListNode(3);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(5);
        listNode2.next = listNode3;
        new Question86().partition(head, 3);

    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
