package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月10日 19:22:31
 * @apiNote:
 */
public class Question187 {
    public static void main(String[] args) {
        Question187 question187 = new Question187();
        String s = "AAAAAAAAAAA";
        System.out.println(question187.findRepeatedDnaSequences(s));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return Collections.emptyList();
        }
        Map<String, Integer> tempMap = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String substring = s.substring(i, i + 10);
            tempMap.compute(substring, (key, oldValue) -> {
                if (Objects.isNull(oldValue)) {
                    oldValue = 0;
                } else if (oldValue == 1) {
                    res.add(key);
                }
                oldValue += 1;
                return oldValue;
            });
        }
        return res;
    }
}
