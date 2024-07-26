package com.code.java.practise.package2;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 08, 2022 4:50:44 PM.
 * @apiNote: .
 */
public class Question171 {
    public static void main(String[] args) {
        Question171 question171 = new Question171();
        System.out.println(question171.titleToNumber("FXSHRXW"));
    }

    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            int character = (int) columnTitle.charAt(i) - 64;
            sum += Math.pow(26, length - i - 1) * character;
        }
        return sum;
    }
}
