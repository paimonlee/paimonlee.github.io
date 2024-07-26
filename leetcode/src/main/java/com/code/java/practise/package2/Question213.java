package com.code.java.practise.package2;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 15, 2022 12:14:04 PM.
 * @apiNote: .
 */
public class Question213 {
    public static void main(String[] args) {
        Question213 question213 = new Question213();
        int[] nums = new int[] { 1, 2, 3 };
        System.out.println(question213.rob(nums));
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
