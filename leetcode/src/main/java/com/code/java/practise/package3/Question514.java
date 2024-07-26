package com.code.java.practise.package3;

import java.util.Deque;
import java.util.LinkedList;

public class Question514 {
    public static void main(String[] args) {
        Question514 question514 = new Question514();
        System.out.println(question514.reverseStr("abc", 2));
    }


    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % (2 * k) == 0) {
                while (!deque.isEmpty()) {
                    sb.append(deque.pop());
                }
            }
            if (i % (2 * k) < k) {
                deque.push(c);
            } else if (i % (2 * k) >= k) {
                deque.addLast(c);
            }
        }
        if (!deque.isEmpty()) {
            while (!deque.isEmpty()) {
                sb.append(deque.pop());
            }
        }
        return sb.toString();
    }
}
