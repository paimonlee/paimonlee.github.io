package com.code.java.practise.package2;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月29日 20:34:52
 * @apiNote:
 */
public class Question115 {
    public static void main(String[] args) {
        Question115 question115 = new Question115();
        int numDistinct = question115.numDistinct("babgbag", "bag");
        System.out.println(numDistinct);
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (i > j) {
                    dp[i][j] = 0;
                } else if (s.charAt(j-1) == t.charAt(i-1)) {
                    dp[i][j] = dp[i - 1][j] == 0 ? 0 : dp[i - 1][j - 1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
