package org.kaidzen.study.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKsDigits {

    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (length == k) {
            return "0";
        }
        Deque<Character> stack = new ArrayDeque<>();
        int counter = 0;
        while (counter < length) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(counter)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(counter));
            counter++;
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKsDigits shortensDigit = new RemoveKsDigits();

//        Input: num = "1432219", k = 3
//        Output: "1219"
        String num = "1432219";
        int k = 3;
        System.out.println(shortensDigit.removeKdigits(num, k));

    }
}
