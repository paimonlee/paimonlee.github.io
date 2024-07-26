package com.code.java.practise.package1;

import com.code.java.practise.utils.TreeNode;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月27日 22:41:59
 * @apiNote: 求树是否是平衡而叉树
 */
public class Question110 {
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
        Question110 question110 = new Question110();
        boolean balanced = question110.isBalanced(treeNode3);
        System.out.println(balanced);

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(high(root.left) - high(root.right)) < 2
                && isBalanced(root.right)
                && isBalanced(root.left);
    }

    private int high(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(high(root.left), high(root.right)) + 1;
    }
}
