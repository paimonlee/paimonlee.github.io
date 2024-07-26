package com.code.java.practise.package3;

import com.code.java.practise.utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 链表重排序
 * 快慢指针找中点
 */
public class Offer026 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Offer026 offer026 = new Offer026();
        offer026.reorderList(listNode);
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
    }
}
