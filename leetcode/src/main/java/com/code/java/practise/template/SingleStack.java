package com.code.java.practise.template;

import java.util.Stack;

/**
 * 单调栈的模板，单调栈用来寻找边界
 */
public class SingleStack {

    /**
     * 单调递增栈
     * @param args
     * @return
     */
    public int increasingStack(Integer[] args) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < args.length) {
            while (!stack.isEmpty() && stack.peek() > args[index]) {
                stack.pop();
            }
            //或者使用栈存储角标
            stack.push(args[index]);
            index++;
        }
        return index;
    }
}
