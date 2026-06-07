package org.kaidzen.study.leetcode.y2025.linkedlist;

import org.kaidzen.study.leetcode.util.ListNode;

public class ReverseLinkedListII_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode l = null;
        ListNode r = null;
        ListNode start = head;

        while (head != null && head.next != null) {
            ListNode lPrev = null;
            ListNode rPrev = null;

            if (head.val == left && l == null) {
                l = head;
            } else if (head.next.val == left) {
                l = head.next;
                lPrev = head;
            }

            if (head.val == right && r == null) {
                r = head;
            } else if (head.next.val == right) {
                r = head.next;
                rPrev = head;
            }

            if (l != null && r != null) {
                if (null != lPrev) {
                    lPrev.next = r;
                }

                if (rPrev != null && null != rPrev.next) {
                    rPrev.next = l;
                }
                ListNode lNext = l.next;
                l.next = r.next;
                r.next = lNext;
            }
            head = head.next;
        }
        return start;
    }
}
