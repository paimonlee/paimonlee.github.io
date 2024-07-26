package com.code.java.practise.package3;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 20, 2022 12:10:06 PM.
 * @apiNote: .
 */
public class Question740 {
    public static void main(String[] args) {
        Question740 question740 = new Question740();
        int[] nums = new int[] { 2, 2, 3, 3, 3, 4 };
        System.out.println(question740.deleteAndEarn(nums));

    }

    public int deleteAndEarn(int[] nums) {
        // 桶排
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] bucket = new int[max - min + 1];
        for (int num : nums) {
            bucket[num - min] += num;
        }
        if (bucket.length == 1) {
            return bucket[0];
        }
        bucket[1] = Math.max(bucket[0], bucket[1]);
        for (int i = 2; i < bucket.length; i++) {
            bucket[i] = Math.max(bucket[i - 2] + bucket[i], bucket[i - 1]);
        }
        return bucket[bucket.length - 1];
        // // 动态规划
        // int first = bucket[0];
        // int second = Math.max(first, bucket[1]);
        // for (int i = 2; i < bucket.length; i++) {
        // int temp = second;
        // second = Math.max(first + bucket[i], second);
        // first = temp;
        // }
        // return second;
    }
}
