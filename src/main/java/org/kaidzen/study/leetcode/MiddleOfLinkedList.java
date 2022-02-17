package org.kaidzen.study.leetcode;

import java.util.Objects;

public class MiddleOfLinkedList {

    private static ListNode head;

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode insert(int data) {
        if (Objects.isNull(head)) {
            head = new ListNode(data);
        } else {
            ListNode temp = new ListNode(data);
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5, 6};
        for (int elem : array1) {
            insert(elem);
        }

        MiddleOfLinkedList checker = new MiddleOfLinkedList();
        System.out.println(checker.middleNode(head).val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
