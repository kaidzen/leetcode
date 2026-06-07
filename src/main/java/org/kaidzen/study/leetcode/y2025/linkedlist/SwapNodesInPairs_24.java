package org.kaidzen.study.leetcode.y2025.linkedlist;

import org.kaidzen.study.leetcode.util.ListNode;

/**
 *
 */
public class SwapNodesInPairs_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head.next;
        ListNode prev = null;
        while(head != null && head.next != null) {
            if (head.next.val == head.val+1) { // B -> C
                if (prev != null) {
                    prev.next = head.next;  // Step 4 A -> D
                }
                prev = head; // save A
                ListNode nextNode = head.next.next; // save -> C
                head.next.next = head; // B -> A

                head.next = nextNode;       // Step 6
                head = nextNode; // -> C

            } else {
                head = head.next;
            }

        }
        return dummy;
    }
}
