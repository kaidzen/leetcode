package org.kaidzen.study.leetcode.y2025.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Removing adjacent duplicated elements with stack.
 */
public class RemoveAllAdjacentDuplicatesInString_1047 {

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString_1047 remover = new RemoveAllAdjacentDuplicatesInString_1047();

        String s = "abbaca";
        System.out.println(remover.removeDuplicates(s));
    }

    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch: s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == ch) {
                stack.pollLast();
            } else {
                stack.offer(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        for (Character ch: stack) {
            res.append(ch);
        }
        return res.toString();
    }
}
