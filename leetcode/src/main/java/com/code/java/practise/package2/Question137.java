package com.code.java.practise.package2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 01, 2022 5:04:19 PM.
 * @apiNote: 进阶版不会.
 */
public class Question137 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.compute(num, (key, oldValue) -> {
                if (Objects.nonNull(oldValue)) {
                    return oldValue + 1;
                }
                return 1;
            });
        }
        Set<Integer> keySet = hashMap.keySet();
        for (Integer integer : keySet) {
            if (hashMap.get(integer) == 1) {
                return integer;
            }
        }
        return 0;
    }
}
