package com.code.java.practise.package3;

/**
 * @author: liyunfeng@fiberhome.com
 * @since: 2022年8月22日-22:44:09
 * @apiNote: 将 i 剪成 j 和 i-j 长度的绳子，且 i−j 不再继续剪，此时的乘积是 j×(i−j) ；
 *           将 i 剪成 j 和 i−j 长度的绳子，且 i−j 继续剪成多段长度的绳子，此时的乘积是 j×dp[i−j] 。
 *           因此，当 j 固定时，有 dp[i]=max(j×(i−j),j×dp[i−j])。由于 j 的取值范围是 1 到 i
 *           ，需要遍历所有的 j 得到dp[i]的
 */
public class Question343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
