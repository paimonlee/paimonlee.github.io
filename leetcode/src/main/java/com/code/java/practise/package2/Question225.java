package com.code.java.practise.package2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: liyunfeng@fiberhome.com
 * @since: 2022年8月18日-16:52:10
 * @apiNote: .
 */
public class Question225 {

}

class MyStack {
    private final Deque<Integer> queue;

    public MyStack() {
        this.queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addFirst(x);
    }

    public int pop() {
        if (this.empty()) {
            return -1;
        }
        return queue.removeFirst();
    }

    public int top() {
        if (this.empty()) {
            return -1;
        }
        return queue.peekFirst();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}