package com.code.java.practise.package2;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月10日 22:31:36
 * @apiNote:
 */
public class Question174 {
    public static void main(String[] args) {
        Question174 question174 = new Question174();
        int[][] dungeon = new int[][] {
                { -2, -3, 3 },
                { -5, -10, 1 },
                { 10, 30, -5 } };
        System.out.println(question174.calculateMinimumHP(dungeon));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : -dungeon[m - 1][n - 1] + 1;
        for (int i = m - 2; i >= 0; i--) {
            int minHp = dp[i + 1][n - 1] - dungeon[i][n - 1];
            dp[i][n - 1] = minHp <= 0 ? 1 : minHp;
        }
        for (int j = n - 2; j >= 0; j--) {
            int minHp = dp[m - 1][j + 1] - dungeon[m - 1][j];
            dp[m - 1][j] = minHp <= 0 ? 1 : minHp;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHp = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = minHp <= 0 ? 1 : minHp;
            }
        }
        return dp[0][0];
    }
    // public int calculateMinimumHP(int[][] dungeon) {
    // int[][] dp = new int[dungeon.length][dungeon[0].length];
    // dp[0][0] = dungeon[0][0] > 0 ? dungeon[0][0] : Math.abs(dungeon[0][0]) + 1;
    // for (int i = 1; i < dp.length - 1; i++) {
    // if (dungeon[i][0] > 0) {
    // dp[i][0] = dp[i - 1][0];
    // } else {
    // dp[i][0] = dp[i - 1][0] + Math.abs(dungeon[i - 1][0] + 1);
    // }
    // }
    // for (int i = 1; i < dp[0].length - 1; i++) {
    // if (dungeon[i][0] > 0) {
    // dp[0][i] = dp[0][i - 1];
    // } else {
    // dp[0][i] = dp[0][i - 1] + Math.abs(dungeon[0][i - 1] + 1);
    // }
    // }
    // for (int i = 1; i < dp.length - 1; i++) {
    // for (int j = 1; j < dp[0].length; j++) {

    // }
    // }
    // }
}
