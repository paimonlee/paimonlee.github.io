package com.code.java.practise.package3;

public class Question136 {
    public static void main(String[] args) {
        Question136 question136 = new Question136();
        int[] nums = new int[]{-1};
        System.out.println(question136.singleNumber(nums));

    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            max = Math.max(max, nums[i]);
//            min = Math.min(min, nums[i]);
//        }
//        int[] count = new int[max - min + 1];
//        for (int i = 0; i < nums.length; i++) {
//            if (count[nums[i] - min] == 1) {
//                count[nums[i] - min] = 0;
//            } else {
//                count[nums[i] - min] = 1;
//            }
//        }
//        for (int i = 0; i < count.length; i++) {
//            if (count[i] == 1) {
//                return i + min;
//            }
//        }
//        return 0;
    }
}
