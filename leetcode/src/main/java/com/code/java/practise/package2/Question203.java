package com.code.java.practise.package2;

import java.util.List;

import com.code.java.practise.utils.ListNode;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月10日 23:05:33
 * @apiNote:
 */
public class Question203 {
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
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(7);
        listNode6.next = listNode7;
        Question203 question203 = new Question203();
        question203.removeElements(listNode1, 7);

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        ListNode result = dummyHead;
        dummyHead.next = head;
        while (dummyHead != null && dummyHead.next != null) {
            if (dummyHead.next.val == val) {
                dummyHead.next = dummyHead.next.next;
                continue;
            }
            dummyHead = dummyHead.next;
        }
        return result.next;
    }
}
