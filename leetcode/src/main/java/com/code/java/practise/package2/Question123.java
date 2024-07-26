package com.code.java.practise.package2;

import javax.xml.transform.Source;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月30日 16:08:00
 * @apiNote:递归转动态规划
 */
public class Question123 {
    public static void main(String[] args) {
        Question123 question123 = new Question123();
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int maxProfit = question123.maxProfit(prices);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {
        int m = prices.length;
        int[][][] dp = new int[m + 1][2][3];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                for (int k = 2; k >= 0; k--) {
                    //买了两手了且手上没有股票
                    if (k == 2 && j == 0) {
                        continue;
                    }
                    if (j == 1) {
                        //手上有股票
                        dp[i][j][k] = Math.max(prices[i] + dp[i + 1][0][k],
                                dp[i + 1][1][k]);
                    } else {
                        //手上没股票
                        dp[i][j][k] = Math.max(-prices[i] + dp[i + 1][1][k + 1],
                                dp[i + 1][0][k]);
                    }
                }
            }
        }
        return dp[0][0][0];
        // return maxProfit(prices, 0, false, 0);
        // int[][] dp = new int[prices.length][prices.length];
        // for (int i = 0; i < dp.length; i++) {
        // dp[0][i] = prices[i] - prices[0];
        // }
        // for (int i = 1; i < prices.length; i++) {
        // for (int j = 0; j < prices.length; j++) {
        // if (i > j) {
        // dp[i][j] = 0;
        // } else {
        // int plan1 = dp[i - 1][i] + prices[j] - prices[i];
        // int plan2 = dp[i - 1][i];
        // int plan3 = prices[j] - prices[i];
        // int plan4 = dp[i][j - 1];
        // dp[i][j] = Math.max(plan4, Math.max(plan3, Math.max(plan1, plan2)));
        // }
        // }
        // }
        // return dp[prices.length - 1][prices.length - 1];

    }

    public int maxProfit(int[] prices, int day, boolean hasStack, int selaCount) {
        // 如果已经买卖了两手了，手上没有彩票也不能卖,不能再进行买卖了,
        if (day >= prices.length || (selaCount >= 2 && !hasStack)) {
            return 0;
        }
        if (hasStack) {
            // 手上有股票则需要考虑卖不卖
            return Math.max(prices[day] + maxProfit(prices, day + 1, false, selaCount),
                    maxProfit(prices, day + 1, true, selaCount));
        }
        return Math.max(-prices[day] + maxProfit(prices, day + 1, true, selaCount + 1),
                maxProfit(prices, day + 1, false, selaCount));

    }

}
