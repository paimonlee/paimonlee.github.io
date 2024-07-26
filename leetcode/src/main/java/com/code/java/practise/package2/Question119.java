package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月30日 15:17:49
 * @apiNote:
 */
public class Question119 {
    public static void main(String[] args) {
        Question119 question119 = new Question119();
        List<Integer> row = question119.getRow(-10);
        System.out.println(row);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(result.get(j) + result.get(j - 1));
                }
            }
            result = temp;
        }
        return result;
    }
}
