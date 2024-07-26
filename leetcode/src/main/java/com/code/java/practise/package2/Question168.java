package com.code.java.practise.package2;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 08, 2022 12:13:53 PM.
 * @apiNote: 十进制转27进制.
 */
public class Question168 {
    public static void main(String[] args) {
        Question168 question168 = new Question168();
        System.out.println(question168.convertToTitle(52));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26;
            sb.append((char) (a0 + 'A'));
            columnNumber = (columnNumber - a0 - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
