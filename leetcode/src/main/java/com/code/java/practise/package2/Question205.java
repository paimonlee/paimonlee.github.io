package com.code.java.practise.package2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:liyunfeng@fiberhome.com.
 * @since : Aug 11, 2022 8:40:58 PM.
 * @apiNote: .
 */
public class Question205 {
    public static void main(String[] args) {
        Question205 question205 = new Question205();
        System.out.println(question205.isIsomorphic("badc", "baba"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2t = new HashMap<>(s.length());
        Map<Character, Character> t2s = new HashMap<>(t.length());
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (s2t.containsKey(sChar) && !(s2t.get(sChar).equals(tChar))) {
                return false;
            }
            if (t2s.containsKey(tChar) && !(t2s.get(tChar).equals(sChar))) {
                return false;
            }
            s2t.put(sChar, tChar);
            t2s.put(tChar, sChar);
        }
        return true;
    }
}
