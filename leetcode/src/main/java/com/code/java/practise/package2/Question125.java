package com.code.java.practise.package2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月30日 22:44:18
 * @apiNote:
 */
public class Question125 {
    public static void main(String[] args) {
        Question125 question125 = new Question125();
        boolean palindrome = question125.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9')
                    || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                        || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString().equalsIgnoreCase(stringBuilder.reverse().toString().toLowerCase());
    }
}
