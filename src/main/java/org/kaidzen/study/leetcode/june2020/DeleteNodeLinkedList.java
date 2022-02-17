package org.kaidzen.study.leetcode.june2020;

import org.kaidzen.study.leetcode.util.ListNode;

public class DeleteNodeLinkedList {

    private ListNode nodeRoot;

    public DeleteNodeLinkedList(ListNode nodeRoot) {
        this.nodeRoot = nodeRoot;

    }


    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public static void main(String[] args) {
//        Input: head = [4,5,1,9], node = 5
//        Output: [4,1,9]

        ListNode nodeRoot = filloutList(new int[]{4, 5, 1, 9});
        DeleteNodeLinkedList nodeManage = new DeleteNodeLinkedList(nodeRoot);
        nodeManage.deleteNode(new ListNode(5));
        System.out.println(nodeRoot);
    }

    private static ListNode filloutList(int[] ints) {
        ListNode root = new ListNode(ints[0]);
        ListNode next = root;
        for (int i = 1; i < ints.length - 1; i++) {
            next.next = new ListNode(i);
            next = next.next;
        }
        return root;
    }
}
