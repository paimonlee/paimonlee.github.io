package com.code.java.practise.weeks.th307;

import java.util.ArrayList;
import java.util.List;

import com.code.java.practise.utils.TreeNode;

/**
 * @author: liyunfeng@fiberhome.com
 * @since: 2022年8月21日-10:49:34
 * @apiNote: .
 */
public class Question3 {
    public static void main(String[] args) {
        Question3 question3 = new Question3();
        TreeNode treeNode = new TreeNode(1);
        System.out.println(question3.amountOfTime(treeNode, 1));
    }

    public int amountOfTime(TreeNode root, int start) {
        return findNode(root, start, null, true);
    }

    private int findNode(TreeNode root, int start, TreeNode parent, boolean right) {
        if (root == null) {
            return 0;
        } else if (root.val == start) {
            return threeWayHigh(root, parent, right);
        }
        return Math.max(findNode(root.left, start, root, false), findNode(root.right, start, root, true));
    }

    private int threeWayHigh(TreeNode root, TreeNode parent, boolean right) {
        if (parent == null) {
            // 感染根节点
            return Math.max(high(root.left), high(root.right));
        }
        if (right) {
            return Math.max(Math.max(high(parent.left) + 1, high(root.left)), high(root.right));
        }
        return Math.max(Math.max(high(parent.right) + 1, high(root.left)), high(root.right));

    }

    private int high(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.right == null && root.left == null) {
            return 1;
        }
        return Math.max(high(root.right) + 1, high(root.left) + 1);
    }

}