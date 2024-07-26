package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 09, 2022 12:24:50 PM.
 * @apiNote: .
 */
public class Question179 {
    public static void main(String[] args) {
        Question179 question179 = new Question179();
        int[] nums = new int[] { 34323, 3432 };
        System.out.println(question179.largestNumber(nums));

    }

    public String largestNumber(int[] nums) {
        List<String> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(String.valueOf(num));
        }
        Collections.sort(numsList, ((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = numsList.size() - 1; i >= 0; i--) {
            stringBuilder.append(numsList.get(i));
        }
        String string = stringBuilder.toString();
        return string.charAt(0) == '0' ? "0" : string;
    }
}
