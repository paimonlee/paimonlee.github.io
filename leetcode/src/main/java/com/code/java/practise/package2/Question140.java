package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 03, 2022 1:31:37 PM.
 * @apiNote: .
 */
public class Question140 {
    public static void main(String[] args) {
        Question140 question140 = new Question140();
        List<String> wordBreak = question140.wordBreak("pineapplepenapple",
                Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        System.out.println(wordBreak);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        dfs(s, wordDict, result, new ArrayList<>());
        return result;
    }

    public void dfs(String s, List<String> wordDict, List<String> result, List<String> tempResult) {
        if (s.length() == 0) {
            result.add(appendList(tempResult));
        }
        for (int i = 0; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            boolean contains = wordDict.contains(substring);
            if (contains) {
                tempResult.add(substring);
                dfs(s.substring(i, s.length()), wordDict, result, tempResult);
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }

    private String appendList(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < list.size(); index++) {
            String entry = list.get(index);
            if (index != list.size() - 1) {
                entry += " ";
            }
            stringBuilder.append(entry);
        }
        return stringBuilder.toString();
    }
}
