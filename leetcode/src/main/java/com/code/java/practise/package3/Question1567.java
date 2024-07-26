package com.code.java.practise.package3;

public class Question1567 {
    public static void main(String[] args) {
        Question1567 question1567 = new Question1567();
        int[] nums = new int[]{5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2};
        System.out.println(question1567.getMaxLen(nums));
    }

    public int getMaxLen(int[] nums) {
        int negNumLen = 0;
        int posNumLen = 0;
        int posNumMaxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                posNumLen = posNumLen + 1;
                negNumLen = negNumLen > 0 ? negNumLen + 1 : negNumLen;
            } else if (nums[i] < 0) {
                int tempPos = negNumLen > 0 ? negNumLen + 1 : negNumLen;
                int tempNeg = posNumLen + 1;
                posNumLen = tempPos;
                negNumLen = tempNeg;
            } else if (nums[i] == 0) {
                negNumLen = 0;
                posNumLen = 0;
            }
            posNumMaxLen = Math.max(posNumMaxLen, posNumLen);
        }
        return posNumMaxLen;
    }
}
