package com.code.java.practise.package2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.code.java.practise.utils.TreeNode;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月30日 21:19:25
 * @apiNote:
 */
public class Question124 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2_ = new TreeNode(-2);
        TreeNode treeNode3_ = new TreeNode(-3);
        treeNode1.left = treeNode2_;
        treeNode1.right = treeNode3_;
        TreeNode treeNode1d = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2_.left = treeNode1d;
        treeNode2_.right = treeNode3;
        TreeNode treeNode2_d = new TreeNode(-2);
        treeNode3_.left = treeNode2_d;
        TreeNode treeNode1_ = new TreeNode(-1);
        treeNode1d.left = treeNode1_;
        Question124 question124 = new Question124();
        int maxPathSum = question124.maxPathSum(treeNode1);
        System.out.println(maxPathSum);

    }

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return result;
    }

    private int maxGain(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int rightGain = Math.max(maxGain(root.right), 0);
        int leftGain = Math.max(maxGain(root.left), 0);

        int all = root.val + rightGain + leftGain;
        result = Math.max(all, result);

        return Math.max(rightGain, leftGain) + root.val;
    }

}
