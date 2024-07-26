package com.code.java.practise.package1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.code.java.practise.utils.ListNode;
import com.code.java.practise.utils.TreeNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Jul 27, 2022 12:04:00 PM.
 * @apiNote: 转换成了array，a了但是需要修改 ,链表类型的题目主要的思想就是分而治之.
 */
public class Question109 {
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

        Question109 question109 = new Question109();
        question109.sortedListToBST(listNode10);

    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> arrayList = new ArrayList<>();
        while (Objects.nonNull(head)) {
            arrayList.add(head.val);
            head = head.next;
        }
        return sortedArrayToBST(arrayList);
    }

    public TreeNode sortedArrayToBST(List<Integer> nums) {
        if (nums.isEmpty()) {
            return null;
        } else if (nums.size() == 1) {
            return new TreeNode(nums.get(0));
        }
        int mid = nums.size() / 2;
        TreeNode rootNode = new TreeNode(nums.get(mid));
        rootNode.left = sortedArrayToBST(nums.subList(0, mid));
        rootNode.right = sortedArrayToBST(nums.subList(mid + 1, nums.size()));
        return rootNode;
    }
}
