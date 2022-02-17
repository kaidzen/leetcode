package org.kaidzen.study.other.lru;

public class Node {

    private String key;
    private String value;
    private Node prev;
    private Node next;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Node setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Node setValue(String value) {
        this.value = value;
        return this;
    }

    public Node getPrev() {
        return prev;
    }

    public Node setPrev(Node prev) {
        this.prev = prev;
        return this;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }
}
