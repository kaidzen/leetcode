package org.kaidzen.study.leetcode.y2023_2024.trie;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ImplementTree {

    public static void main(String[] args) {
//        final List<String> source = Arrays.asList("Trie", "insert", "search", "search", "startsWith", "insert", "search");
        final List<String> source = Arrays.asList(null, "startsWith");
//        final List<String> list = Arrays.asList(null, "apple", "apple", "app", "app", "app", "app");
        final List<String> list = Arrays.asList(null, "a");

        Trie inTest = new Trie();

        source.forEach(inTest::insert);

        list.forEach(word -> {
            System.out.println(inTest.search(word) + " ");

        });
        System.out.println("=======");
        list.forEach(word -> {
            System.out.println(inTest.startsWith(word) + " ");

        });
    }



    private static class Trie {
        private final static Trie root = new Trie();
        private final Trie[] children = new Trie[57];
        private boolean isEnd;

        /** Initialize your data structure here. */
        public Trie() {
            Arrays.fill(children, null);
            this.isEnd = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (Objects.isNull(word) || word.isEmpty()) return;
            Trie node = root;
            for (char ch: word.toCharArray()) {
                int idx = childIdx(ch);
                if (node.children[idx] == null) node.children[idx] = new Trie();
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word == null) {
                return false;
            }

            Trie node = root;
            for (char ch: word.toCharArray()) {
                int idx = childIdx(ch);
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            return node != null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix == null) return false;

            Trie node = root;
            for (char ch: prefix.toCharArray()) {
                int idx = childIdx(ch);
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            return true;
        }

        private int childIdx(char ch) {
            return ch - 'A';
        }
    }
}
