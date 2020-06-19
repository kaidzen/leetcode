package org.kaidzen.study.leetcode.util;

public class TrieNode {
    private TrieNode[] next;
    private int value;
    private int depth;

    public TrieNode(int value, int depth) {
        this.value = value;
        this.depth = depth;
    }

    public TrieNode[] getNext() {
        return next;
    }

    public void setNext(TrieNode[] next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
