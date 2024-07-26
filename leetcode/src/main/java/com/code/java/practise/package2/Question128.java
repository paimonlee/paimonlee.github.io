package com.code.java.practise.package2;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月31日 10:36:22
 * @apiNote:
 */
public class Question128 {
    public static void main(String[] args) {
        Question128 question128 = new Question128();
        int[] nums = { 9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7 };
        System.out.println(question128.longestConsecutiveOld(nums));
    }

    public int longestConsecutiveOld(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            int count = 0;
            while (isContainNum(nums, i + 1)) {
                count++;
                i++;
            }
            max = Math.max(count, max);
        }
        return max + 1;

    }

    private boolean isContainNum(int[] nums, int value) {
        for (int i : nums) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int count = 0;
                while (set.contains(i + 1)) {
                    count++;
                    i++;
                }
                max = Math.max(count, max);
            }
        }
        return max + 1;
    }
}
