package com.code.java.practise.package3;

import java.util.ArrayList;
import java.util.List;

public class Question228 {
    public static void main(String[] args) {
        Question228 question228 = new Question228();
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 8,8,8};
        System.out.println(question228.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            int temp = i;
            while (temp < nums.length - 1 && nums[temp + 1] - nums[temp] == 1) {
                temp++;
            }
            if (temp == i) {
                result.add(sb.toString());
            } else {
                sb.append("->" + nums[temp]);
                result.add(sb.toString());
            }
            i = temp + 1;
        }
        return result;
    }
}
