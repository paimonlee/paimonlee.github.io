package com.code.java.practise.package2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.code.java.practise.utils.RandomNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 02, 2022 2:53:32 PM.
 * @apiNote: 一次a，瞬间出结果wocao.
 */
public class Question138 {

    private Map<RandomNode, RandomNode> list = new HashMap<>();

    public RandomNode copyRandomList(RandomNode head) {
        if (Objects.isNull(head)) {
            return head;
        }
        if (list.containsKey(head)) {
            return list.get(head);
        } else {
            RandomNode randomNode = new RandomNode(head.val);
            list.put(head, randomNode);
            randomNode.next = copyRandomList(head.next);
            randomNode.random = copyRandomList(head.random);
            return randomNode;
        }
    }
}
