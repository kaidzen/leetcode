package org.kaidzen.study.leetcode.util;

import java.util.Arrays;

public class Trie {

    private final Trie[] children = new Trie[26];
    private static final Trie root = new Trie();
    private boolean isEndOfWord;

    public Trie() {
        Arrays.fill(children, null);
        this.isEndOfWord = false;
    }

    public void insert(String word) {
        Trie next = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (next.children[index] == null) {
                next.children[index] = new Trie();
            }
            next = next.children[index];
        }
        next.isEndOfWord = true;
    }

    public boolean search(String word) {
        Trie next = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (next.children[index] == null) {
                return false;
            }
            next = next.children[index];
        }
        return next != null && next.isEndOfWord;
    }

    public boolean startWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (root.children[index] == null) {
                return false;
            }
        }
        return true;
    }

    public Trie[] getChildren() {
        return this.children;
    }

    public boolean isEndOfWord() {
        return this.isEndOfWord;
    }
}
