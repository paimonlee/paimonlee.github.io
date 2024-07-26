package com.code.java.practise.package2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.code.java.practise.utils.ListNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 04, 2022 12:11:07 PM.
 * @apiNote: 快慢指针找中点.
 */
public class Question143 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(6);
        // listNode5.next = listNode6;
        Question143 question143 = new Question143();
        question143.reorderList(listNode1);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode result = head;
        ListNode slowPoint = head;
        ListNode fastPoint = head;
        while (fastPoint.next != null && fastPoint.next.next != null) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
        }
        ListNode nextListNode = slowPoint.next;
        slowPoint.next = null;
        Deque<ListNode> stack = new LinkedList<>();
        while (nextListNode != null) {
            stack.push(nextListNode);
            nextListNode = nextListNode.next;
        }
        while (stack.size() != 0) {
            ListNode pop = stack.pop();
            pop.next = result.next;
            result.next = pop;
            result = result.next.next;
        }
        return;
    }
}
