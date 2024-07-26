package com.code.java.practise.package2;

import java.util.Collections;
import java.util.List;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月30日 15:33:25
 * @apiNote:
 */
public class Question120 {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        } else if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        // for (int i = 1; i < triangle.size(); i++) {
        // List<Integer> lastLevel = triangle.get(i - 1);
        // List<Integer> thisLevel = triangle.get(i);
        // for (int j = 0; j < thisLevel.size(); j++) {
        // if (j == 0) {
        // thisLevel.set(j, thisLevel.get(j) + lastLevel.get(j));
        // } else if (j == thisLevel.size() - 1) {
        // thisLevel.set(j, thisLevel.get(j) + lastLevel.get(j - 1));
        // } else {
        // thisLevel.set(j, thisLevel.get(j) + Math.min(lastLevel.get(j - 1),
        // lastLevel.get(j)));
        // }
        // }
        // }
        // return Collections.min(triangle.get(triangle.size() - 1));
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int value = triangle.get(i).get(j)
                        + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, value);
            }
        }
        return triangle.get(0).get(0);
    }
}
