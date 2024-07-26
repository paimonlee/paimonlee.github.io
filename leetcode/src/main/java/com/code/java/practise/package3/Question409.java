package com.code.java.practise.package3;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 22, 2022 12:17:08 PM.
 * @apiNote: .
 */
public class Question409 {
    public static void main(String[] args) {
        Question409 question409 = new Question409();
        System.out.println(question409.longestPalindrome("abccccddzzAAZZ"));
    }

    public int longestPalindrome(String num) {
        int[] count = new int[58];
        for (int i = 0; i < num.length(); i++) {
            Integer valueOf = num.charAt(i) - 'A';
            count[valueOf] += 1;
        }
        int len = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] >= 2) {
                len++;
                count[i] -= 2;
            }
        }
        len *= 2;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                len++;
                break;
            }
        }
        return len;
    }
}
