package com.code.java.practise.package2;

import java.util.HashSet;
import java.util.Set;

import com.code.java.practise.utils.ListNode;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月07日 12:03:21
 * @apiNote: 使用list 时间920ms,使用hashset时间5ms，使用双指针，不需要判断是否存在，时间1ms
 */
public class Question160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> list = new HashSet<>();
        while (headA != null) {
            list.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (list.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeDoublePoint(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
