package org.kaidzen.study.leetcode.y2025.stackNqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * There are 3 major points to track: frequency of the characters, character been seen or not,
 * stack that will accumulate
 * the result.
 */
public class RemoveDuplicateLetters_316 {

    public static void main(String[] args) {
        RemoveDuplicateLetters_316 filter = new RemoveDuplicateLetters_316();

        String s = "bcabc";
        System.out.println(filter.removeDuplicateLetters(s)); // abc
        String s2 = "cbacdcbc";
        System.out.println(filter.removeDuplicateLetters(s2)); // acdb
        String s3 = "bbcaac";
        System.out.println(filter.removeDuplicateLetters(s3)); // bac
    }

    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] occurrence = new char[26];
        Set<Character> seen = new HashSet<>();

        for (char ch : s.toCharArray()) {
            occurrence[ch - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            if (!seen.contains(ch)) {
                while (!stack.isEmpty() && stack.peekLast() > ch && occurrence[stack.peekLast() - 'a'] > 0) {
                    seen.remove(stack.pollLast());
                }
                seen.add(ch);
                stack.offer(ch);
                occurrence[ch - 'a']--;
            } else {
                occurrence[ch - 'a']--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (Character ch : stack) {
            res.append(ch);
        }

        return res.toString();
    }
}
