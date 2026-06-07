package org.kaidzen.study.leetcode.y2025.stackNqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given a string s, which contains stars *.
 * <p>
 * In one operation, you can:
 * <p>
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * <p>
 * Note:
 * <p>
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 */
public class RemovingStarsFromString_2390 {

    public static void main(String[] args) {
        RemovingStarsFromString_2390 remover = new RemovingStarsFromString_2390();
        String s = "leet**cod*e";
        System.out.println(remover.removeStars(s)); // lecoe
    }

    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != '*') {
                stack.offer(cur);
            } else {
                if (i > 0) {
                    stack.pollLast();
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (Character ch : stack) {
            res.append(ch);
        }
        return res.toString();
    }
}
