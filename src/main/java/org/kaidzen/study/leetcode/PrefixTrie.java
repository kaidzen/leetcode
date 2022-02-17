package org.kaidzen.study.leetcode;

import java.util.Arrays;

public class PrefixTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}

class Trie {

    private final Trie[] children = new Trie[26];
    private static final Trie root = new Trie();
    private boolean isEndOfWord;

    /**
     * Initialize your data structure here.
     */
    Trie() {
        Arrays.fill(children, null);
        this.isEndOfWord = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int index;
        int length = word.length();
        Trie next = root;
        for (int i = 0; i < length; i++) {
            index = word.charAt(i) - 'a';
            if (next.children[index] == null) {
                next.children[index] = new Trie();
            }
            next = next.children[index];
        }
        next.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        int length = word.length();
        int index;
        Trie next = root;

        for (int i = 0; i < length; i++) {
            index = word.charAt(i) - 'a';

            if (next.children[index] == null)
                return false;

            next = next.children[index];
        }
        return (next != null && next.isEndOfWord);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        int length = prefix.length();
        int index;
        Trie next = root;

        for (int i = 0; i < length; i++) {
            index = prefix.charAt(i) - 'a';

            if (next.children[index] == null)
                return false;
        }
        return true;
    }
}

