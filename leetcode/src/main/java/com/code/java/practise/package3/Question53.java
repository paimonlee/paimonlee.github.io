package com.code.java.practise.package3;

public class Question53 {
    public int maxSubArray(int[] nums) {
        int cursum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cursum = Math.max(cursum + nums[i], nums[i]);
            max = Math.max(max, cursum);
        }
        return max;
    }
}
