package org.kaidzen.study.leetcode.june2020;

import org.kaidzen.study.leetcode.util.TrieNode;

public class LongestDuplicatedSubstring {

    private String str;

    public String longestDupSubstring(String S) {
        this.str = S;
        int maxIndex = 0;
        int maxLength = 0;
        TrieNode root = new TrieNode(0, 0);
        for (int i = 1; i + maxLength < S.length(); i++) {
            int len = addNew(root, i);
            if (len > maxLength) {
                maxLength = len;
                maxIndex = i;
            }
        }
        return S.substring(maxIndex, maxIndex + maxLength);
    }

    private boolean isLeaf(TrieNode node) {
        return node.getNext() == null;
    }

    private int getIndex(int i, int depth) {
        return this.str.charAt(i + depth) - 'a';
    }

    private int addNew(TrieNode node, int i) {
        int depth = node.getDepth();
        if (i + depth == this.str.length()) return depth;
        if (isLeaf(node)) {
            node.setNext(new TrieNode[26]);
            node.getNext()[getIndex(node.getValue(), node.getDepth())] = new TrieNode(node.getValue(), depth + 1);
        }
        int c = getIndex(i, node.getDepth());
        TrieNode x = node.getNext()[c];
        if (x == null) {
            node.getNext()[c] = new TrieNode(i, depth + 1);
            return depth;
        }
        return addNew(x, i);
    }

    public static void main(String[] args) {

    }
}
