package org.kaidzen.study.other.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LruCache {

    private final Map<String, Node> map;
    private int capacity;
    private Node head = null;
    private Node tail = null;
    private final Deque<Node> list;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.list = new LinkedList<>();
    }

    private void deleteFromList(Node node) {
        this.list.remove(node);
        if (this.head != null && head.equals(node)) {
            this.head = head.getPrev();
        }
        if (this.tail != null && this.tail.equals(node)) {
            this.tail = tail.getNext();

        }
    }

    private void setListHead(Node node) {
        boolean isAdded = this.list.offerFirst(node);
        if (isAdded) {
            this.head = node;
            if (this.list.size() == 1) {
                this.tail = node;
            }
        }
    }

    public String get(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            deleteFromList(node);
            setListHead(node);

            return node.getValue();
        } else {
            return null;
        }
    }

    public void put(String key, String value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteFromList(node);

            node.setValue(value);
            setListHead(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(tail.getKey());
                deleteFromList(tail);
            }

            Node node = new Node(key, value);
            map.put(key, node);
            setListHead(node);
        }
    }
}
