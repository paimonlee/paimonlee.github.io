package com.code.java.practise.package2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月07日 21:14:59
 * @apiNote:
 */
public class Question166 {
    public static void main(String[] args) {
        Question166 question166 = new Question166();
        int numerator = 4;
        int denominator = 333;
        System.out.println(question166.fractionToDecimalNew(numerator, denominator));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        Long numeratorLong = Long.valueOf(numerator);
        Long denominatorLong = Long.valueOf(denominator);
        StringBuilder sBuilder = new StringBuilder();
        if (numeratorLong * denominatorLong < 0 && numeratorLong / denominatorLong == 0) {
            sBuilder.append("-" + numeratorLong / denominatorLong);
        } else {
            sBuilder.append(numeratorLong / denominatorLong);
        }
        // String
        StringBuilder decimalBuilder = new StringBuilder();
        numeratorLong = Math.abs(numeratorLong % denominatorLong);
        denominatorLong = Math.abs(denominatorLong);
        // 用于记录numerator出现过的状态
        Map<Long, Integer> map = new HashMap<>();
        int count = 0;
        while (numeratorLong != 0) {
            if (map.containsKey(numeratorLong)) {
                int index = map.get(numeratorLong);
                decimalBuilder.insert(index, "(");
                decimalBuilder.append(")");
                break;
            }
            map.put(numeratorLong, count);
            int countZero = 0;
            while (numeratorLong < denominatorLong) {
                numeratorLong *= 10;
                if (countZero > 0) {
                    decimalBuilder.append(0);
                    count++;
                }
                countZero++;
            }
            decimalBuilder.append(numeratorLong / denominatorLong);
            count++;
            numeratorLong = numeratorLong % denominatorLong;
        }
        return decimalBuilder.toString().length() == 0 ? sBuilder.toString()
                : sBuilder.toString() + "." + decimalBuilder.toString();
    }

    public String fractionToDecimalNew(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long a = numerator, b = denominator;
        if (a * b < 0) {
            sb.append('-');
        }
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b);
        if (a % b == 0) {
            return sb.toString();
        }
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while ((a = (a % b) * 10) > 0 && !map.containsKey(a)) {
            map.put(a, sb.length());
            sb.append(a / b);
        }
        if (a == 0) {
            return sb.toString();
        }
        return sb.insert(map.get(a).intValue(), '(').append(')').toString();
    }
}
