package com.code.java.practise.weeks.th309;

import java.util.Arrays;
import java.util.HashMap;

/**
 * k步移动从start到达end 缓存递归
 */
public class Question2 {

    public static void main(String[] args) {
        Question2 question2 = new Question2();
        System.out.println(question2.numberOfWays(1, 2, 3));
    }


    public static final Integer MOD = (int) (Math.pow(10, 9) + 7);

    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3001][3001];
        for (int i = 0; i < 3001; i++) {
            for (int j = 0; j < 3001; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(startPos + 1001, endPos + 1001, k, dp);
    }

    private int dfs(int startPos, int endPos, int k, int[][] dp) {
        if (k < Math.abs(endPos - startPos)) {
            return 0;
        } else if (k == 0 && startPos == endPos) {
            return 1;
        } else if (k == 0) {
            return 0;
        }
        if (dp[startPos][k] != -1) {
            return dp[startPos][k];
        }
        int res = 0;
        res += (dfs(startPos + 1, endPos, k - 1, dp) % MOD);
        res += (dfs(startPos - 1, endPos, k - 1, dp) % MOD);
        int result = (res % MOD);
        dp[startPos][k] = result;
        return res;
    }
}
