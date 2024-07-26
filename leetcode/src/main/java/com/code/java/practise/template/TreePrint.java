package com.code.java.practise.template;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Consumer;

import com.code.java.practise.utils.TreeNode;

public class TreePrint {

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inorder(TreeNode root, Consumer<TreeNode> consumer) {
        if (root == null) {
            return;
        }
        inorder(root.left, consumer);
        // doSomething
        consumer.accept(root);
        inorder(root.right, consumer);
    }

    /**
     * 先序遍历
     *
     * @param root
     */
    public void preorder(TreeNode root, Consumer<TreeNode> consumer) {
        if (root == null) {
            return;
        }
        // doSomething
        consumer.accept(root);
        preorder(root.left, consumer);
        preorder(root.right, consumer);
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postorder(TreeNode root, Consumer<TreeNode> consumer) {
        if (root == null) {
            return;
        }
        postorder(root.left, consumer);
        postorder(root.right, consumer);
        // doSomething
        consumer.accept(root);
    }

    //层序遍历
    public void levelOrder(TreeNode root, Consumer<TreeNode> consumer) {
        if (Objects.isNull(root)) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        //add root node
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            //consume the node,doSomething here
            consumer.accept(poll);
            //add left node if it is not null
            if (Objects.nonNull(poll.left)) {
                queue.add(poll.left);
            }
            //add right node if it is not null
            if (Objects.nonNull(poll.right)) {
                queue.add(poll.right);
            }
        }
    }
}
