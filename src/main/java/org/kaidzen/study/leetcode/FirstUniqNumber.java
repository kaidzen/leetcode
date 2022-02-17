package org.kaidzen.study.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqNumber {

    private final Map<Integer, Node> uniques;
    private Node head;
    private Node tail;

    public FirstUniqNumber(int[] nums) {
        uniques = new HashMap<>(nums.length);
        head = null;
        tail = null;
    }

    public int showFirstUnique() {
        return head == null ? -1 : head.value;
    }

    public void add(int value) {
        if (uniques.containsKey(value)) remove(value);
        else append(value);
    }

    private void append(int value) {
        Node node = new Node(value);
        uniques.put(value, node);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            //TODO implement logic
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    private void remove(int value) {
        Node node = uniques.get(value);
        if (node.isIndependent() && head != node) return; // already removed from list

        // remove from list
        if (node == head) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node == tail) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        node.reset();
    }

    private class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            next = null;
            prev = null;
        }

        void reset() {
            next = prev = null;
        }

        boolean isIndependent() {
            return (next == null) && (prev == null);
        }

        boolean equals(Node n) {
            return value == n.value;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5};
        FirstUniqNumber firstUnique = new FirstUniqNumber(arr);
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
    }
}
