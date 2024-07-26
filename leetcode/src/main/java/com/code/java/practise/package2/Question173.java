package com.code.java.practise.package2;

import java.util.Deque;
import java.util.LinkedList;

import javax.swing.text.AbstractDocument.LeafElement;

import com.code.java.practise.utils.TreeNode;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月08日 22:33:40
 * @apiNote: 二叉树迭代器
 */
public class Question173 {
    public static void main(String[] args) {

    }

}

class BSTIterator {
    private Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        TreeNode current = pop.right;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

// class BSTIterator {
// private Deque<TreeNode> queue = new LinkedList<>();

// public BSTIterator(TreeNode root) {
// fillQueus(root);
// }

// public int next() {
// return queue.pop().val;
// }

// public boolean hasNext() {
// return !queue.isEmpty();
// }

// private void fillQueus(TreeNode root) {
// if (root == null) {
// return;
// }
// if (root.left != null) {
// fillQueus(root.left);
// }
// queue.add(root);
// if (root.right != null) {
// fillQueus(root.right);
// }
// }
// }