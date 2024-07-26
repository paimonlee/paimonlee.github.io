package com.code.java.practise.package2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月06日 20:59:03
 * @apiNote: leetcode的编译器不能使用==判等
 */
public class Question150 {
    public static void main(String[] args) {
        String[] tokens = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        Question150 question150 = new Question150();
        int evalRPN = question150.evalRPN(tokens);
        System.out.println(evalRPN);
    }

    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String string : tokens) {
            if (string.equals("+") || string.equals("-") || string.equals("/") || string.equals("-")) {
                String num1 = stack.removeFirst();
                String num2 = stack.removeFirst();
                // num2 string num1
                if (string.equals("+")) {
                    stack.addFirst(String.valueOf(Integer.valueOf(num2) + Integer.valueOf(num1)));
                } else if (string.equals("-")) {
                    stack.addFirst(String.valueOf(Integer.valueOf(num2) - Integer.valueOf(num1)));
                } else if (string.equals("/")) {
                    stack.addFirst(String.valueOf(Integer.valueOf(num2) / Integer.valueOf(num1)));
                } else {
                    stack.addFirst(String.valueOf(Integer.valueOf(num2) * Integer.valueOf(num1)));
                }
            } else {
                stack.addFirst(string);
            }
        }
        return Integer.valueOf(stack.removeFirst());
    }
}
