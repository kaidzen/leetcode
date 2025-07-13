package org.kaidzen.study.leetcode.y2025.hashtables;


/**
 * Basic HashMap with 3 simple methods.
 * base structure to store values - array.
 * Key converted to index by hashing with mod of fixed array size.
 * Collisions are resolved by chaining key->value pairs with the same hash.
 */
public class DesignHashmap_706 {

    private final int MOD = 10001;
    private final ListNode[] table;

    public static void main(String[] args) {

    }

    public DesignHashmap_706() {
        this.table = new ListNode[MOD];
    }

    public void put(int key, int value) {
        int idx = hash(key);
        ListNode node = new ListNode(key, value);
        if (table[idx] == null) {
            table[idx] = node;

        }
        ListNode cur = table[idx];
        ListNode prev = null;
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            if (prev != null) {
                prev.next = cur;

            }
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) {
            prev.next = node;
        }
    }

    public int get(int key) {
        int idx = hash(key);
        ListNode cur = table[idx];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = hash(key);
        if (table[idx] == null) return;

        ListNode node = table[idx];
        ListNode cur = node;
        ListNode prev = null;
        while (cur != null) {
            if (cur.key == key) {
                if (prev == null) {
                    table[idx] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                return;
            }
            if (prev != null) {
                prev.next = cur;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    private int hash(int key) {
        return key % MOD;
    }

    static class ListNode {
        int key;
        int value;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


}
