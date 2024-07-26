package com.code.java.practise.package2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月31日 12:42:46
 * @apiNote:还有顺序问题？？？？？？使用list会导致顺序,使用队列
 */
public class Question131 {
    public static void main(String[] args) {
        Question131 question131 = new Question131();
        List<List<String>> partition = question131.partition("cbbbcc");
        System.out.println(partition);
    }

    public List<List<String>> partition(String s) {
        partition(s, new ArrayDeque<>());
        return result;
    }

    private List<List<String>> result = new ArrayList<>();

    public void partition(String s, Deque<String> temp) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            if (isBackWord(substring)) {
                temp.addLast(substring);
                partition(s.substring(i, s.length()), temp);
                temp.removeLast();
            }
        }
    }

    private boolean isBackWord(String s) {
        for (int i = 0, j = s.length() - 1; i < s.length() - 1 && i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
