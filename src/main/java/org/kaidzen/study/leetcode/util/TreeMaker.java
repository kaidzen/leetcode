package org.kaidzen.study.leetcode.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaker {

    public static void main(String[] args) {
        print(create(new Integer[]{3, 9, 20, null, null, 15, 7}));
        print(create(new Integer[]{1, null, 2}));
    }

    public static TreeNode create(Integer[] source) {
        if (source == null || source.length == 0 || source[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(source[0]);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < source.length) {
            TreeNode parent = queue.poll();
            if (i < source.length) {
                Integer leftVal = source[i++];
                if (leftVal != null) {
                    parent.left = new TreeNode(leftVal);
                    queue.offer(parent.left);
                }
            }
            if (i < source.length) {
                Integer rightVal = source[i++];
                if (rightVal != null) {
                    parent.right = new TreeNode(rightVal);
                    queue.offer(parent.right);
                }
            }
        }
        return root;
    }

    public static void print(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        while (sb.length() > 1 && (sb.charAt(sb.length() - 1) == ',' || sb.substring(Math.max(0, sb.length() - 5)).endsWith("null,"))) {
            if (sb.substring(Math.max(0, sb.length() - 5)).endsWith("null,")) {
                sb.setLength(sb.length() - 5);
            } else {
                break;
            }
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setLength(sb.length() - 1);
        }
        sb.append("]");
        System.out.println(sb);
    }
}
