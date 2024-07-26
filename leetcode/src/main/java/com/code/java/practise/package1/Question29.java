package com.code.java.practise.package1;

/**
 * Function introduction: .
 * Writer: liyunfeng
 * Writing time: 2022-03-18 19:36:59
 */
public class Question29 {
    public static void main(String[] args) {

    }
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        long dividedLong=dividend;
        long divisorLong=divisor;
        //2^31 -1
        int maxValue = Integer.MAX_VALUE;
        //−2^31
        int minValue = Integer.MIN_VALUE;
        if (dividedLong == minValue && divisorLong == -1) {
            return maxValue;
        }
        //同号为正，异号为负
        int sign = (dividedLong < 0 && divisorLong < 0) || (dividedLong > 0 && divisorLong > 0) ? 1 : -1;
        dividedLong = Math.abs(dividedLong);
        divisorLong = Math.abs(divisorLong);
        int result = 0;
        long step;
        while (dividedLong >= divisorLong) {
            //关键点在于如果divisor增长的太大了，
            // 就会从清零到原值，从新增长
            step = 1;
            long temp = divisorLong;
            while (dividedLong >= temp) {
                dividedLong -= temp;
                result += step;
                step <<= 1;
                temp <<= 1;
            }
        }
        return sign < 0 ? -result : result;
    }
}
