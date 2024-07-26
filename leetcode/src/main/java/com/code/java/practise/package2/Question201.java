package com.code.java.practise.package2;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月10日 22:59:00
 * @apiNote:
 */
public class Question201 {
    public static void main(String[] args) {
        Question201 question201 = new Question201();
        System.out.println(question201.rangeBitwiseAnd(0, 2147483647));
    }

    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0) {
            return 0;
        }
        int res = left;
        for (long i = left; i < (long) right + 1; i++) {
            res &= i;
        }
        return res;
    }
}
