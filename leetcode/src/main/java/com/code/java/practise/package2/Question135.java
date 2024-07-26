package com.code.java.practise.package2;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月06日 21:16:17
 * @apiNote: 老版本使用递归的思想计算，耗时327ms,新方法使用贪心的方法计算，耗时2ms
 */
public class Question135 {
    public static void main(String[] args) {
        int[] ratings = new int[] { 1, 2, 2 };
        Question135 question135 = new Question135();
        question135.candy(ratings);
    }

    public int candy(int[] ratings) {
        if (ratings.length < 2) {
            return ratings.length;
        }
        int[] dp = new int[ratings.length];
        dp[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i + 1] + 1, dp[i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;
    }

    public int candyOld(int[] ratings) {
        if (ratings.length < 2) {
            return ratings.length;
        }
        int[] ratingsNew = new int[ratings.length + 2];
        ratingsNew[0] = -1;
        ratingsNew[ratingsNew.length - 1] = -1;
        for (int i = 0; i < ratings.length; i++) {
            ratingsNew[i + 1] = ratings[i];
        }
        int[] dp = new int[ratingsNew.length];
        for (int i = 1; i < ratingsNew.length - 1; i++) {
            int tempIndex = i;
            while (ratingsNew[tempIndex] > ratingsNew[tempIndex + 1] && tempIndex < ratingsNew.length - 2) {
                tempIndex++;
            }
            dp[i] = tempIndex - i + 1;
            if (ratingsNew[i] > ratingsNew[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
