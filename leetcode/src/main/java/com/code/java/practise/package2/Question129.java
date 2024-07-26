package com.code.java.practise.package2;

import java.util.Objects;

import com.code.java.practise.utils.TreeNode;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月30日 23:00:46
 * @apiNote:
 */
public class Question129 {
    public static void main(String[] args) {

    }

    private int result = 0;

    public int sumNumbers(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        dfs(root, stringBuilder);
        return result;
    }

    private void dfs(TreeNode root, StringBuilder stringBuilder) {
        if (Objects.isNull(root)) {
            return;
        }
        if (isLeafNode(root)) {
            result += Integer.valueOf(stringBuilder.append(root.val).toString());
        }
        StringBuilder append = stringBuilder.append(root.val);
        dfs(root.left, new StringBuilder(append));
        dfs(root.right, new StringBuilder(append));
    }

    // 是否是叶子节点
    private boolean isLeafNode(TreeNode root) {
        return Objects.nonNull(root) && Objects.isNull(root.left) && Objects.isNull(root.right);
    }
}
