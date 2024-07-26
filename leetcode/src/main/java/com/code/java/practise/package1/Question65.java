package com.code.java.practise.package1;

/**
 * 有效数字，考虑使用动态规划
 */
public class Question65 {
    public static void main(String[] args) {
        System.out.println(new Question65().isNumber("-.9"));
    }

    public boolean isNumber(String s) {
        boolean hasE = false;
        boolean hasNum = false;
        boolean isFloat = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 符号位只能在首位或E的后一位
            if ((c == '-' || c == '+') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

            } else if ((c == 'e' || c == 'E') && !hasE && hasNum) {
                //只存在一个E, 前面必须有数字, 后面也必须有数字
                hasE = true;
                hasNum = false;
            } else if (c == '.' && !isFloat && !hasE) {
                //只存在一个小数点, 不能在E的后面
                isFloat = true;
            } else if (c >= '0' && c <= '9') {
                hasNum = true;
            } else {
                return false;
            }
        }
        return hasNum;
    }
}
