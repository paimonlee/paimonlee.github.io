package com.code.java.practise.package3;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 19, 2022 12:14:30 PM.
 * @apiNote: .
 */
public class Question215 {
    public static void main(String[] args) {
        Question215 question215 = new Question215();
        int[] nums = new int[] { 3, 2, 3, 2, 4, 5, 5, 6 };
        int k = 4;
        System.out.println(question215.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] - min]++;
        }
        int count = 0;
        for (int j = bucket.length - 1; j >= 0; j--) {
            count += bucket[j];
            if (count >= k) {
                return j + min;
            }
        }
        return -1;
    }
}
