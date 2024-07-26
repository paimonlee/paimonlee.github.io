package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月31日 11:11:49
 * @apiNote: bfs+图
 * 广度有限搜索，用于寻找图的最短路径
 *  从节点A出发，有前往节点B的路吗？
    从节点A出发，前往节点B的哪条路径最短？
 */
public class Qusetion127 {
    public static void main(String[] args) {
        Qusetion127 qusetion127 = new Qusetion127();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot", "dot", "dog", "lot", "hit", "log", "cog"));
        System.out.println(qusetion127.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }

}
