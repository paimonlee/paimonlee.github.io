package com.code.java.practise.package2;

import java.util.Arrays;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 11, 2022 5:06:08 PM.
 * @apiNote: .
 */
public class Question204 {
    public static void main(String[] args) {
        Question204 question204 = new Question204();
        System.out.println(question204.countPrimes(2));
    }
    //埃氏筛
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i * i < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }

        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }
    // public int countPrimes(int n) {
    //     int count = 0;
    //     for (int i = 2; i < n; i++) {
    //         if (isPrimeNumber(i)) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // private boolean isPrimeNumber(int n) {
    //     for (int i = 2; i < Math.sqrt(n); i++) {
    //         if (n % i == 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
