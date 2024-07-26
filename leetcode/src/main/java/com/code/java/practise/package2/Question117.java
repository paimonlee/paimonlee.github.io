package com.code.java.practise.package2;

import com.code.java.practise.utils.Node;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月29日 21:50:19
 * @apiNote:
 */
public class Question117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.left != null && root.right == null) {
            root.left.next = getNext(root.next);
        }
        if (root.right != null) {
            root.right.next = getNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    public Node getNext(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            return root.left;
        }
        if (root.right != null) {
            return root.right;
        }
        if (root.next != null) {
            return getNext(root.next);
        }
        return null;
    }
}
