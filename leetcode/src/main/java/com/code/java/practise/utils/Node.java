package com.code.java.practise.utils;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月29日 21:29:02
 * @apiNote:
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
};
