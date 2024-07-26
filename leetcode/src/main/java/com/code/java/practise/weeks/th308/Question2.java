package com.code.java.practise.weeks.th308;

import java.util.Deque;
import java.util.LinkedList;

public class Question2 {

    public static void main(String[] args) {
        Question2 question2 = new Question2();
        System.out.println(question2.removeStars("leet**cod*e"));
    }

    public String removeStars(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
