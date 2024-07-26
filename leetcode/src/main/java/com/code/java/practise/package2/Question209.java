package com.code.java.practise.package2;

public class Question209 {
    public static void main(String[] args) {
        Question209 question209 = new Question209();
        int target = 7;
        int[] nums = new int[] { 8, 3, 1, 2, 4, 3 };
        System.out.println(question209.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
