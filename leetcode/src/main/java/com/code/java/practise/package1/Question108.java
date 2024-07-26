package com.code.java.practise.package1;
import java.util.ArrayList;
import java.util.List;

import com.code.java.practise.utils.TreeNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Jul 26, 2022 12:04:24 PM.
 * @apiNote: 有序数组构造二叉树.
 */
public class Question108 {
    public static void main(String[] args) {
        int[] nums = { 1,3 };
        Question108 question108 = new Question108();
        TreeNode sortedArrayToBST = question108.sortedArrayToBST(nums);
        return;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        return sortedArrayToBST(numsList);
    }

    public TreeNode sortedArrayToBST(List<Integer> nums) {
        if (nums.isEmpty()) {
            return null;
        } else if (nums.size() == 1) {
            return new TreeNode(nums.get(0));
        }
        int mid = nums.size() / 2;
        TreeNode rootNode = new TreeNode(nums.get(mid));
        rootNode.left = sortedArrayToBST(nums.subList(0, mid));
        rootNode.right = sortedArrayToBST(nums.subList(mid + 1, nums.size()));
        return rootNode;
    }

}
