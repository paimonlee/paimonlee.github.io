package com.code.java.practise.package2;

import java.util.Arrays;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月31日 13:08:33
 * @apiNote: 官方题解
 */
public class Question132 {

    public static void main(String[] args) {
        Question132 question132 = new Question132();
        int minCut = question132.minCut("aab");
        System.out.println(minCut);
    }

    public int minCut(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }
}
