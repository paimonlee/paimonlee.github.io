package com.code.java.practise.package1;

import java.util.*;

/**
 * 超时
 */
public class Question76Enhance {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = new Question76Enhance().minWindow("ADOBECODEBANC",
                "ABC");
        System.out.println(s);
        System.out.println(System.currentTimeMillis() - start);
    }

    Map<Character, Integer> tMap = new HashMap<>();
    Map<Character, Integer> filterSMap = new HashMap<>();

    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0;
        int end = 0;
        int resStart = 0;
        int resEnd = end;
        int len = Integer.MAX_VALUE;
        while (end < s.length()) {
            if (tMap.containsKey(s.charAt(end))) {
                filterSMap.put(s.charAt(end), filterSMap.getOrDefault(s.charAt(end), 0) + 1);
            }
            //判断start-end是否是子串
            while (isContain() && start <= end) {
                if (end - start < len) {
                    len = end - start + 1;
                    resEnd = start + len;
                    resStart = start;
                }
                if (tMap.containsKey(s.charAt(start))) {
                    filterSMap.put(s.charAt(start), filterSMap.getOrDefault(s.charAt(start), 0) - 1);
                }
                start++;
            }
            //如果不是子串，右角标右移
            end++;
        }
        return resStart == resEnd ? "" : s.substring(resStart, resEnd);
    }

    private boolean isContain() {
        //判断是否是子串,就是目前这个截取的字符串要完全包含t的字母，而且包含的字母的个数要相等
        Iterator<Map.Entry<Character, Integer>> iterator = tMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            if (filterSMap.getOrDefault(next.getKey(), 0) < next.getValue()) {
                return false;
            }
        }
        return true;
    }
}
