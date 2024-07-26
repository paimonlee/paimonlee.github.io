package com.code.java.practise.package2;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 08, 2022 5:17:29 PM.
 * @apiNote: .
 */
public class Question172 {
    public static void main(String[] args) {
        Question172 question172 = new Question172();
        System.out.println(question172.trailingZeroes(30));
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
