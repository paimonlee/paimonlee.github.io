package com.code.java.practise.package2;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 15, 2022 12:33:24 PM.
 * @apiNote: .
 */
public class Question509 {
    public static void main(String[] args) {
        Question509 question509 = new Question509();
        System.out.println(question509.fib(3));
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int index = 2; index <= n; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }
}
