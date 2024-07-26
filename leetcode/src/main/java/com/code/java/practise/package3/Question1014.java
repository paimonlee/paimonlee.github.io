package com.code.java.practise.package3;

public class Question1014 {
    public static void main(String[] args) {
        Question1014 question1014 = new Question1014();
        int[] values = new int[]{1, 2};
        System.out.println(question1014.maxScoreSightseeingPair(values));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int length = values.length;
        int left = values[0];
        int right = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            left = Math.max(left, values[i] + i);
            right = Math.max(right, left + values[i] - i);
        }
        return right;
    }

}
