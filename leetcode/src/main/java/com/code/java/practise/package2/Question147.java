package com.code.java.practise.package2;

import java.util.Objects;

import com.code.java.practise.utils.ListNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 05, 2022 11:58:55 AM.
 * @apiNote: .
 */
public class Question147 {
    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(-1);
        ListNode listNode2 = new ListNode(5);
        listNode4.next = listNode2;
        ListNode listNode1 = new ListNode(3);
        listNode2.next = listNode1;
        ListNode listNode3 = new ListNode(4);
        ListNode listNode0 = new ListNode(0);
        listNode1.next = listNode3;
        listNode3.next = listNode0;
        Question147 question147 = new Question147();
        question147.insertionSortList(listNode4);

    }

    public ListNode insertionSortList(ListNode head) {
        if (Objects.isNull(head)) {
            return head;
        }
        ListNode virtual = new ListNode(Integer.MIN_VALUE);
        ListNode result = virtual;
        while (!Objects.isNull(head)) {
            int value = head.val;
            // find index
            while (!Objects.isNull(virtual.next) && virtual.next.val < value) {
                virtual = virtual.next;
            }
            ListNode listNode = new ListNode(value);
            listNode.next = virtual.next;
            virtual.next = listNode;
            head = head.next;
            virtual = result;
        }
        return result.next;
    }
}
