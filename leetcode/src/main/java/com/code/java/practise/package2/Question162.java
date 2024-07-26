package com.code.java.practise.package2;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月07日 13:38:22
 * @apiNote:
 */
public class Question162 {
    public static void main(String[] args) {
        Question162 question162 = new Question162();
        int[] nums = new int[] { 1, 2, 3, 1 };
        System.out.println(question162.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
