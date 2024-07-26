package com.code.java.practise.weeks.th306;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月14日-10:49:00
 * @apiNote: .
 */
public class Question2 {
    public static void main(String[] args) {
        Question2 question2 = new Question2();
        int[] edges = new int[] { 1, 0, 1, 1, 1 };
        int edgeScore = question2.edgeScore(edges);
        System.out.println(edgeScore);
    }

    public int edgeScore(int[] edges) {
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int to = edges[i];
            if (map.containsKey(to)) {
                Long integer = map.get(to);
                integer += i;
                map.put(to, integer);
            } else {
                map.put(to, (long) i);
            }
        }
        Long max = Long.MIN_VALUE;
        int node = 0;
        Set<Integer> keySet = map.keySet();
        for (Integer to : keySet) {
            Long sum = map.get(to);
            if (sum > max) {
                max = sum;
                node = to;
            } else if (sum == max && to < node) {
                node = to;
            }
        }
        return node;
    }
}
