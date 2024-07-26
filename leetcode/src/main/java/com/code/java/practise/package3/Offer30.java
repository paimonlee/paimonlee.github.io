package com.code.java.practise.package3;

import java.util.Deque;
import java.util.LinkedList;

public class Offer30 {
}

class MinStack {

    Deque<Integer> minStack = new LinkedList<>();
    Deque<Integer> data = new LinkedList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        Integer peek = minStack.peek();
        if (x < peek) {
            minStack.push(x);
        } else {
            minStack.push(peek);
        }
        data.push(x);
    }

    public void pop() {
        minStack.pop();
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return minStack.peek();
    }
}