package com.code.java.practise.package2;

import java.util.Objects;

import com.code.java.practise.utils.TreeNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Jul 28, 2022 11:58:45 AM.
 * @apiNote: .
 */
public class Question111 {
    public static void main(String[] args) {
        TreeNode treeNode_2 = new TreeNode(-2);
        TreeNode treeNode_3 = new TreeNode(-3);
        treeNode_2.right = treeNode_3;
        Question111 question111 = new Question111();
        boolean hasPathSum = question111.hasPathSum(treeNode_2, -5);
        System.out.println(hasPathSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }

    /**
     * 递归
     * 
     * @param node    当前节点
     * @param rootSum 根节点到父节点的总和
     * @return
     */
    public boolean hasPathSum(TreeNode node, int rootSum, int targetSum) {
        if (Objects.isNull(node)) {
            return false;
        } else if (isLeafNode(node)) {
            if (rootSum + node.val == targetSum) {
                return true;
            }
            return false;
        } else {
            // 无法提前终止，因为其他的节点可能是负值
            // if ((targetSum >= 0 && rootSum + node.val > targetSum)
            //         || (targetSum < 0 && rootSum + node.val < targetSum)) {
            //     return false;
            // }
            return hasPathSum(node.left, rootSum + node.val, targetSum)
                    || hasPathSum(node.right, rootSum + node.val, targetSum);
        }
    }

    // 是否是叶子节点
    private boolean isLeafNode(TreeNode root) {
        return Objects.nonNull(root) && Objects.isNull(root.left) && Objects.isNull(root.right);
    }
}
