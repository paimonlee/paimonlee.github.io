package com.code.java.practise.package3;


/**
 * 6 和 9 组成的最大数字
 */
public class Question1323 {
    public static void main(String[] args) {
        Question1323 question1323 = new Question1323();
        System.out.println(question1323.maximum69Number(9669));
    }

    public int maximum69Number(int num) {
        String nums = String.valueOf(num);
        int len = nums.length();
        for (int i = 0; i < len; i++) {
            if (nums.charAt(i) == '6') {
                num += (3 * Math.pow(10, len - i - 1));
                break;
            }
        }
        return num;
    }
}
