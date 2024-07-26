package com.code.java.practise.weeks.th309;

import com.code.java.practise.package3.Question1323;

import java.util.ArrayList;
import java.util.List;

public class Question3 {
    public static void main(String[] args) {
        Question3 question3 = new Question3();
        int[] nums = new int[]{3, 1, 5, 11, 13};
        System.out.println(question3.longestNiceSubarray1(nums));
    }

    public int longestNiceSubarray1(int[] nums) {
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int num : nums) {
            numList.add(num);
        }
        int start = 0;
        int end = 1;
        while (start != end && end <= nums.length) {
            if (isGoog(numList.subList(start, end))) {
                max = Math.max(max, end - start);
                end++;
            } else {
                start++;
            }
        }
        return max;
    }

    private int max = Integer.MIN_VALUE;

    public int longestNiceSubarray(int[] nums) {
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int num : nums) {
            numList.add(num);
        }
        dfs(numList, new ArrayList<>(), 0);
        return max;
    }

    private void dfs(List<Integer> numList, List<Integer> result, int index) {
        if (index >= numList.size()) {
            max = Math.max(max, result.size());
        }
        for (int i = index; i < numList.size(); i++) {
            result.add(numList.get(index));
            if (!isGoog(result)) {
                result.remove(result.size() - 1);
            }
            dfs(numList, result, index + 1);
        }
    }

    private boolean isGoog(List<Integer> result) {
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if ((result.get(i) & result.get(j)) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
