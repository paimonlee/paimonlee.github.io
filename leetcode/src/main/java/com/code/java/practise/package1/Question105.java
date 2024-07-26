package com.code.java.practise.package1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.code.java.practise.utils.TreeNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Jul 25, 2022 9:49:42 AM.
 * @apiNote: 通过先序遍历中序遍历返回树的结构.
 */
public class Question105 {
    public static void main(String[] args) {
        Question105 question105 = new Question105();
        // int[] preorder = { 3, 9, 20, 15, 7 };
        // int[] inorder = { 9, 3, 15, 20, 7 };
        int[] preorder = { 1, 2 };
        int[] inorder = { 2, 1 };
        question105.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preList = new ArrayList<>();
        for (int preEntry : preorder) {
            preList.add(preEntry);
        }
        List<Integer> inList = new ArrayList<>();
        for (int inEntry : inorder) {
            inList.add(inEntry);
        }
        return buildTree(preList, inList);
    }

    public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (inorder.isEmpty()) {
            return null;
        } else if (inorder.size() == 1) {
            return new TreeNode(preorder.get(0));
        }
        Integer rootVal = preorder.get(0);
        int indexOfRoot = inorder.indexOf(rootVal);
        List<Integer> leftNodeList = inorder.subList(0, indexOfRoot);
        List<Integer> leftPreorder = preorder.subList(1, leftNodeList.size() + 1);
        List<Integer> rightNodeList = inorder.subList(indexOfRoot + 1, inorder.size());
        List<Integer> rightPreorder = preorder.subList(leftNodeList.size() + 1, preorder.size());
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(leftPreorder, leftNodeList);
        root.right = buildTree(rightPreorder, rightNodeList);
        return root;
    }
}
