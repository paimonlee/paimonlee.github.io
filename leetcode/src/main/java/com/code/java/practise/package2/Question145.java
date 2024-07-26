package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.code.java.practise.utils.TreeNode;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月03日 20:55:33
 * @apiNote:
 */
public class Question145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }

    private void postOrderTraversal(TreeNode root, List<Integer> result) {
        if (Objects.isNull(root)) {
            return;
        }
        if (Objects.nonNull(root.left)) {
            postOrderTraversal(root.left, result);
        }
        if (Objects.nonNull(root.right)) {
            postOrderTraversal(root.right, result);
        }
        result.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
