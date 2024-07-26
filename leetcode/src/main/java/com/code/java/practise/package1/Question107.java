package com.code.java.practise.package1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Consumer;

import com.code.java.practise.utils.TreeNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Jul 25, 2022 4:38:44 PM.
 * @apiNote: .
 */
public class Question107 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        new Question107().levelOrderBottom(treeNode1);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayDeque<List<Integer>> tempResult = new ArrayDeque<>();
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<Integer> levelElementList = new ArrayList<>();
        // this level element counter
        int levelElementCount = 0;
        // next level element counter
        int nextElementCount = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        levelElementCount = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            levelElementList.add(poll.val);
            levelElementCount--;
            if (Objects.nonNull(poll.left)) {
                nextElementCount++;
                queue.add(poll.left);
            }
            if (Objects.nonNull(poll.right)) {
                nextElementCount++;
                queue.add(poll.right);
            }
            // if this level element count over
            // get next level element count ,and reset next level element counter
            if (levelElementCount == 0) {
                levelElementCount = nextElementCount;
                nextElementCount = 0;
                tempResult.addFirst(new ArrayList<>(levelElementList));
                levelElementList.clear();
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(tempResult);
        return result;
    }
}
