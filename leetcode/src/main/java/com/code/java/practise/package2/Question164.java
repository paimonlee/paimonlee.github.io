package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月07日 13:57:24
 * @apiNote:线性时间的排序算法，需要基数排序或者桶排序,,
 */
public class Question164 {
    public static void main(String[] args) {
        Question164 question164 = new Question164();
        int[] nums = new int[] { 3, 6, 9, 1 };
        System.out.println(question164.maximumGap(nums));
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list);
        int max = 0;
        for (int i = list.size() - 1; i > 0; i--) {
            max = Math.max(list.get(i) - list.get(i - 1), max);
        }
        return max;
    }
}
