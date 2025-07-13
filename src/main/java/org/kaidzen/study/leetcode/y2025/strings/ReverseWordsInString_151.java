package org.kaidzen.study.leetcode.y2025.strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Reverse words in the provided string. Two pointers used for word evaluation boundary.
 * Stack used as additional memory, then just FIFO protocol done.
 * T = O(n)
 * S = O(n)
 */
public class ReverseWordsInString_151 {

    public static void main(String[] args) {
        ReverseWordsInString_151 rw = new ReverseWordsInString_151();

        String s = "the sky is blue";
        System.out.println(rw.reverseWords(s)); //"blue is sky the"
    }

    public String reverseWords(String s) {
        int len = s.length();
        int l = 0;
        int wL;
        int wR;

        Deque<String> queue = new ArrayDeque<>();

        while (l < len) {
            char current = s.charAt(l);
            if (!Character.isWhitespace(current)) {
                wL = l;
                int nextSpace = s.indexOf(" ", wL);
                wR = nextSpace == -1 ? len : nextSpace;
                queue.offer(s.substring(wL, wR));
                l += wR - wL;
            }
            l++;
        }
        StringBuilder sb = new StringBuilder();

        sb.append(queue.pollLast());
        while (!queue.isEmpty()) {
            sb.append(" ");
            sb.append(queue.pollLast());
        }
        return sb.toString();

    }
}
