package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.code.java.practise.utils.TreeNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Jul 29, 2022 12:11:37 PM.
 * @apiNote: 优化版，内存消耗排名上升90%，时间消耗排名上升95%.
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.97% 的用户
 * 内存消耗：41.4 MB, 在所有 Java 提交中击败了96.34% 的用户
 */
public class Question113Enhance {
    public static void main(String[] args) {
        TreeNode treeNode_2 = new TreeNode(-2);
        TreeNode treeNode_3 = new TreeNode(-3);
        treeNode_2.right = treeNode_3;
        Question113 question113 = new Question113();
        List<List<Integer>> pathSum = question113.pathSum(treeNode_2, -5);
        System.out.println(pathSum);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, 0, targetSum, new ArrayList<>(), result);
        return result;
    }

    public void pathSum(TreeNode node, int rootSum, int targetSum, List<Integer> nodes, List<List<Integer>> result) {
        if (isLeafNode(node)) {
            if (rootSum + node.val == targetSum) {
                nodes.add(node.val);
                result.add(new ArrayList<>(nodes));
                // 删除最后一次添加的
                nodes.remove(nodes.size() - 1);
            }
        } else {
            nodes.add(node.val);
            pathSum(node.left, rootSum + node.val, targetSum, new ArrayList<>(nodes), result);
            pathSum(node.right, rootSum + node.val, targetSum, new ArrayList<>(nodes), result);
            // 删除最后一次添加的
            nodes.remove(nodes.size() - 1);
        }
    }

    // 是否是叶子节点
    private boolean isLeafNode(TreeNode root) {
        return Objects.nonNull(root) && Objects.isNull(root.left) && Objects.isNull(root.right);
    }
}
