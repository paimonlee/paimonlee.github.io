package com.code.java.practise.package1;
import java.util.Objects;

import com.code.java.practise.utils.ListNode;
import com.code.java.practise.utils.TreeNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Jul 27, 2022 12:51:23 PM.
 * @apiNote: .
 */
public class Question109Enhance {

    public static void main(String[] args) {
        ListNode listNode10 = new ListNode(-10);
        ListNode listNode3 = new ListNode(-3);
        listNode10.next = listNode3;
        ListNode listNode0 = new ListNode(0);
        listNode3.next = listNode0;
        ListNode listNode5 = new ListNode(5);
        listNode0.next = listNode5;
        ListNode listNode9 = new ListNode(9);
        listNode5.next = listNode9;

        Question109Enhance question109Enhance = new Question109Enhance();
        TreeNode sortedListToBST = question109Enhance.sortedListToBST(listNode10);
        return;

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = head;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next) && Objects.nonNull(fast.next)) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow即为中点
        TreeNode treeNode = new TreeNode(slow.val);
        preSlow.next = null;
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(slow.next);
        return treeNode;
    }
}
