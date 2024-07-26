package com.code.java.practise.template;

import com.code.java.practise.utils.TreeNode;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月27日 23:01:30
 * @apiNote:求树的高度，分而治之 
 */
public class HighOfTree {
    public int high(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(high(root.left), high(root.right)) + 1;
    }
}
