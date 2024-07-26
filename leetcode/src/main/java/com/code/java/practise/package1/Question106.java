package com.code.java.practise.package1;

import java.util.ArrayList;
import java.util.List;

import com.code.java.practise.utils.TreeNode;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Jul 25, 2022 11:07:17 AM.
 * @apiNote: .
 */
public class Question106 {

    public static void main(String[] args) {
        Question106 question106 = new Question106();
        // int[] preorder = { 3, 9, 20, 15, 7 };
        // int[] inorder = { 9, 3, 15, 20, 7 };
        int[] inorder = { 3, 2, 1 };
        int[] postorder = { 3, 2, 1 };
        question106.buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inList = new ArrayList<>();
        for (int inEntry : inorder) {
            inList.add(inEntry);
        }
        List<Integer> postList = new ArrayList<>();
        for (int postEntry : postorder) {
            postList.add(postEntry);
        }
        return buildTree(inList, postList);
    }

    public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        if (inorder.isEmpty()) {
            return null;
        } else if (inorder.size() == 1) {
            return new TreeNode(postorder.get(0));
        }
        Integer rootVal = postorder.get(postorder.size() - 1);
        int indexOfRoot = inorder.indexOf(rootVal);

        List<Integer> leftNodeList = inorder.subList(0, indexOfRoot);
        List<Integer> rightNodeList = inorder.subList(indexOfRoot + 1, inorder.size());

        List<Integer> leftPostorder = postorder.subList(0, leftNodeList.size());
        List<Integer> rightPostorder = postorder.subList(leftNodeList.size(),
                rightNodeList.size() + leftNodeList.size());
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(leftNodeList, leftPostorder);
        root.right = buildTree(rightNodeList, rightPostorder);
        return root;
    }

}
