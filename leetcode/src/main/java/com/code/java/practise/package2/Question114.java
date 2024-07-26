package com.code.java.practise.package2;

import java.util.Objects;

import com.code.java.practise.utils.TreeNode;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月29日 20:02:32
 * @apiNote:
 */
public class Question114 {
    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode3.right = treeNode20;
        treeNode3.left = treeNode9;
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode20.left = treeNode15;
        treeNode15.right = treeNode7;
        Question114 question114 = new Question114();
        question114.flatten(treeNode3);
    }

    public void flatten(TreeNode root) {
        preorder(root);
    }

    public TreeNode preorder(TreeNode root) {
        TreeNode result = root;
        if (root == null) {
            return null;
        }
        // doSomething
        TreeNode rightNode = preorder(root.left);
        root.left = null;
        TreeNode otherRightNode = preorder(root.right);
        root.right = rightNode;
        while (root.right != null) {
            root = root.right;
        }
        root.right = otherRightNode;
        return result;
    }
}
