package com.code.java.practise.package2;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 15, 2022 12:38:51 PM.
 * @apiNote: .
 */
public class Question1137 {
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        } else if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
