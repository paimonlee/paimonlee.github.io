package com.code.java.practise.weeks.th306;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月14日-11:09:19
 * @apiNote: .
 */
public class Question3 {
    public static void main(String[] args) {
        Question3 question3 = new Question3();
        System.out.println(question3.smallestNumber("IIII"));
    }

    public String smallestNumber(String pattern) {
        String res = "";
        String num = "123456789";
        int i = 0;
        for (; i < pattern.length();) {
            int index = i;
            while (index < pattern.length() && pattern.charAt(index) == pattern.charAt(i)) {
                index++;
            }
            if (pattern.charAt(i) == 'I') {
                String substring = num.substring(i, index);
                i = index;
                res += substring.toString();
            } else {
                String substring = num.substring(i, index + 1);
                i = index + 1;
                StringBuilder sb = new StringBuilder();
                sb.append(substring);
                res += sb.reverse().toString();
            }
        }
        if (pattern.endsWith("I") && pattern.length() < 9) {
            res += num.substring(i, i + 1);
        }
        return res;
    }
}
