package com.code.java.practise.package1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.code.java.practise.utils.TreeNode;


public class Question99 {
    public static void main(String[] args) {

    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, entry -> {
            list.add(entry);
        });
        TreeNode maxNode = null;
        TreeNode minNode = null;
        //扫面遍历的结果，找出可能存在错误交换的节点x和y
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i).val > list.get(i + 1).val) {
                minNode = list.get(i + 1);
                if (maxNode == null) {
                    maxNode = list.get(i);
                }
            }
        }
        //如果x和y不为空，则交换这两个节点值，恢复二叉搜索树
        if (maxNode != null && minNode != null) {
            int tmp = maxNode.val;
            maxNode.val = minNode.val;
            minNode.val = tmp;
        }
    }
    public void inorder(TreeNode root, Consumer<TreeNode> consumer) {
        if (root == null) {
            return;
        }
        inorder(root.left, consumer);
        //doSomething
        consumer.accept(root);
        inorder(root.right, consumer);
    }
}
