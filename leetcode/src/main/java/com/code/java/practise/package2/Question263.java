package com.code.java.practise.package2;

import java.util.Arrays;
import java.util.List;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 11, 2022 8:51:35 PM.
 * @apiNote: .
 */
public class Question263 {
    public static void main(String[] args) {
        Question263 question263 = new Question263();
        System.out.println(question263.isUgly(8));

    }
    public boolean isUgly(int num) {
        if (num<1) return false;
        while (num%5==0){
            num/=5;
        }
        while (num%3==0){
            num/=3;
        }
        while (num%2==0){
            num>>=1;
        }
        return num == 1;
    }
}
