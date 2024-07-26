package com.code.java.practise.package2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月11日 22:32:37
 * @apiNote: 字典树
 */
public class Ｑuestion208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("applc");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }

}

class Trie {
    private Tree head;

    public Trie() {
        this.head = new Tree("");
    }

    public void insert(String word) {
        Tree head = this.head;
        for (int i = 0; i < word.length(); i++) {
            String s = String.valueOf(word.charAt(i));
            Map<String, Tree> map = head.map;
            if (map.containsKey(s)) {
                head = map.get(s);
            } else {
                Tree tree = new Tree(head.val + s);
                map.put(s, tree);
                head = tree;
            }
        }
        head.exist = true;
    }

    public boolean search(String word) {
        Tree head = this.head;
        for (int index = 0; index < word.length(); index++) {
            String valueOf = String.valueOf(word.charAt(index));
            Map<String, Tree> map = head.map;
            if (map.containsKey(valueOf)) {
                head = map.get(valueOf);
            } else {
                return false;
            }
        }
        return head.exist;
    }

    public boolean startsWith(String prefix) {
        Tree head = this.head;
        for (int index = 0; index < prefix.length(); index++) {
            String valueOf = String.valueOf(prefix.charAt(index));
            Map<String, Tree> map = head.map;
            if (map.containsKey(valueOf)) {
                head = map.get(valueOf);
            } else {
                return false;
            }
        }
        return true;
    }
}

class Tree {
    String val;
    boolean exist;
    Map<String, Tree> map = new HashMap<>();

    public Tree(String val) {
        this.val = val;
    }
}