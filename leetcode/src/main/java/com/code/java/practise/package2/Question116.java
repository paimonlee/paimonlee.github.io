package com.code.java.practise.package2;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

import com.code.java.practise.utils.Node;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月29日 21:30:08
 * @apiNote:
 */
public class Question116 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.left = node4;
        node2.right = node5;
        Node node7 = new Node(7);
        node3.right = node7;
        Question116 question116 = new Question116();
        question116.connect(node1);
    }

    public Node connect(Node root) {
        return levelOrderBottom(root);
    }

    public Node levelOrderBottom(Node root) {
        if (Objects.isNull(root)) {
            return root;
        }
        // this level element counter
        int levelElementCount = 0;
        // next level element counter
        int nextElementCount = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        levelElementCount = 1;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            poll.next = queue.peek();
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
                poll.next = null;
            }
        }
        return root;
    }
}
