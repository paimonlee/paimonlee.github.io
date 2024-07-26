package com.code.java.practise.weeks.th307;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: liyunfeng@fiberhome.com
 * @since: 2022年8月21日-10:47:02
 * @apiNote: .
 */
public class Question2 {
    public static void main(String[] args) {
        Question2 question2 = new Question2();
        System.out.println(question2.largestPalindromic("0000000000000000000000"));
    }

    public String largestPalindromic(String num) {
        StringBuilder left = new StringBuilder();
        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            Integer valueOf = Integer.valueOf(String.valueOf(num.charAt(i)));
            count[valueOf] += 1;
        }
        for (int i = 9; i >= 0; i--) {
            while (count[i] >= 2) {
                if (left.length() == 0 && i == 0) {
                    break;
                } else {
                    left.append(i);
                    count[i] -= 2;
                }
            }
        }
        StringBuilder right = new StringBuilder(left).reverse();
        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                left.append(i);
                break;
            }
        }
        left.append(right);
        return left.toString();
    }
}
