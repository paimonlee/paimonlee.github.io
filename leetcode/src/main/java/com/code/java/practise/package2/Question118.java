package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月29日 21:53:09
 * @apiNote:
 */
public class Question118 {
    public static void main(String[] args) {
        Question118 question118 = new Question118();
        List<List<Integer>> generate = question118.generate(5);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);
            List<Integer> lastLevel = result.get(result.size() - 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    int value = lastLevel.get(j - 1) + lastLevel.get(j);
                    list.add(value);
                }
            }
            result.add(list);
        }
        return result;
    }
}
