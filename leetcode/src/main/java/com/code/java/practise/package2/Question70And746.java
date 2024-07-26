package com.code.java.practise.package2;

import java.util.Arrays;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 16, 2022 10:27:29 AM.
 * @apiNote: 动规训练第二天.
 */
public class Question70And746 {
    public static void main(String[] args) {
        Question70And746 question70 = new Question70And746();
        int[] cost = new int[] { 1, 100 };
        System.out.println(question70.minCostClimbingStairs(cost));
    }

    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int minCostClimbingStairs(int[] cost) {
        int high = cost.length;
        if (high == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] copyOf = Arrays.copyOf(cost, high + 1);
        int[] dp = new int[copyOf.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + copyOf[i];
        }
        return dp[copyOf.length - 1];
    }
}
