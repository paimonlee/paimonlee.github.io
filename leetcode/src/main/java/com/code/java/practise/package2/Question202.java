package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月10日 22:48:57
 * @apiNote:
 */
public class Question202 {
    public static void main(String[] args) {
        Question202 question202 = new Question202();
        System.out.println(question202.isHappy(2));

    }

    private List<Integer> cache = new ArrayList<>();

    public boolean isHappy(int n) {
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            sum += Math.pow(num, 2);
            n /= 10;
        }
        if (sum == 1) {
            return true;
        } else if (cache.contains(sum)) {
            return false;
        } else {
            cache.add(sum);
            return isHappy(sum);
        }
    }
}
