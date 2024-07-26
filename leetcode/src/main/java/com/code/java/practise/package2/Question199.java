package com.code.java.practise.package2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Consumer;

import com.code.java.practise.utils.TreeNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 11, 2022 4:58:37 PM.
 * @apiNote: .
 */
public class Question199 {
    public static void main(String[] args) {

    }

    // 层序遍历
    public List<Integer> rightSideView(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        // add root node
        queue.add(root);
        int levelCount = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            levelCount--;
            // consume the node,doSomething here
            // consumer.accept(poll);
            // add left node if it is not null
            if (Objects.nonNull(poll.left)) {
                queue.add(poll.left);
                count++;
            }
            // add right node if it is not null
            if (Objects.nonNull(poll.right)) {
                queue.add(poll.right);
                count++;
            }
            if (levelCount == 0) {
                // level over
                levelCount = count;
                res.add(poll.val);
                count = 0;
            }
        }
        return res;
    }
}
