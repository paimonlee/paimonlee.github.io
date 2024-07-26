package com.code.java.practise.package3;

public class Question918 {
    public static void main(String[] args) {
        Question918 question918 = new Question918();
        System.out.println(question918.maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int minCurSum = nums[0];
        int minSum = nums[0];
        int maxCurSum = nums[0];
        int maxSum = nums[0];
        int allSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minCurSum = Math.min(minCurSum + nums[i], nums[i]);
            minSum = Math.min(minCurSum, minSum);
            maxCurSum = Math.max(maxCurSum + nums[i], nums[i]);
            maxSum = Math.max(maxCurSum, maxSum);
            allSum += nums[i];
        }
        if(allSum==minSum){
            return maxSum;
        }
        return Math.max(maxSum, allSum - minSum);
    }
}
