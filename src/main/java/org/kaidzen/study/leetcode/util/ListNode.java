package org.kaidzen.study.leetcode.util;

import java.util.Objects;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode of(int[] arr) {
        int len = arr.length;
        ListNode head = null;
        if (arr.length == 0) return head;
        head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i=1; i < len; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                "}\n";
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof ListNode listNode)) return false;

        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + Objects.hashCode(next);
        return result;
    }
}
