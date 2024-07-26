package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 12, 2022 12:06:50 PM.
 * @apiNote: .
 */
public class Question216 {
    public static void main(String[] args) {
        Question216 question216 = new Question216();
        System.out.println(question216.combinationSum3(2, 18));

    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int k, int n, List<Integer> temp, Integer lastIndex) {
        if (temp.size() == k && sumNums(temp) == n) {
            res.add(new ArrayList<>(temp));
            return;
        } else if (temp.size() == k && sumNums(temp) != n) {
            return;
        } else if (sumNums(temp) > n) {
            return;
        } else {
            for (int i = lastIndex + 1; i <= 9; i++) {
                temp.add(i);
                dfs(k, n, temp, i);
                temp.remove(temp.indexOf(i));
            }
        }
    }

    private Integer sumNums(List<Integer> temp) {
        int sum = 0;
        for (Integer integer : temp) {
            sum += integer;
        }
        return sum;
    }
}
