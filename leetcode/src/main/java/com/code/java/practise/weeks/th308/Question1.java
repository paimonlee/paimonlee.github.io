package com.code.java.practise.weeks.th308;

import java.util.ArrayList;
import java.util.Collections;

public class Question1 {
    public static void main(String[] args) {
        Question1 question1 = new Question1();
        int[] nums = new int[]{4, 5, 2, 1};
        int[] queries = new int[]{3, 10, 21};
        question1.answerQueries(nums, queries);
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] result = new int[queries.length];
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        Collections.sort(numsList);
        for (int j = 0; j < queries.length; j++) {
            int que = queries[j];
            int sum = 0;
            int i = 0;
            for (; i < numsList.size(); i++) {
                sum += numsList.get(i);
                if (sum > que) {
                    result[j] = i;
                    break;
                }
            }
            if (i == numsList.size()) {
                result[j] = i;
            }
        }
        return result;
    }

}
