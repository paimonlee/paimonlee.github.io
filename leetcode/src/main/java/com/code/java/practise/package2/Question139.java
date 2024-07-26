package com.code.java.practise.package2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 03, 2022 12:10:10 PM.
 * @apiNote: 深度递归超时，优化为动态规划.
 */
public class Question139 {
    public static void main(String[] args) {
        Question139 question139 = new Question139();
        System.out.println(question139.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
    }

    // public boolean wordBreak(String s, List<String> wordDict) {
    // if (s.length() == 0) {
    // return true;
    // }
    // for (int i = 0; i < s.length() + 1; i++) {
    // String substring = s.substring(0, i);
    // boolean contains = wordDict.contains(substring);
    // if (contains && wordBreak(s.substring(i, s.length()), wordDict)) {
    // return true;
    // }
    // }
    // return false;
    // }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
