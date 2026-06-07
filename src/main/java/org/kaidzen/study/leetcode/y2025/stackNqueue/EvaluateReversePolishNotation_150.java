package org.kaidzen.study.leetcode.y2025.stackNqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation_150 {

    public static void main(String[] args) {
        EvaluateReversePolishNotation_150 checker = new EvaluateReversePolishNotation_150();

        String[] tokens = new String[] {"2","1","+","3","*"};
        System.out.println(checker.evalRPN(tokens)); // 9
    }

    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (String ch : tokens) {
            if ("+".equals(ch)) {
                stack.offer(String.valueOf(Integer.parseInt(stack.pollLast()) + Integer.parseInt(stack.pollLast())));
            } else if ("-".equals(ch)) {
                int a = Integer.parseInt(stack.pollLast());
                int b = Integer.parseInt(stack.pollLast());
                stack.offer(String.valueOf(b - a));
            } else if ("*".equals(ch)) {
                stack.offer(String.valueOf(Integer.parseInt(stack.pollLast()) * Integer.parseInt(stack.pollLast())));
            } else if ("/".equals(ch)) {
                int a = Integer.parseInt(stack.pollLast());
                int b = Integer.parseInt(stack.pollLast());
                stack.offer(String.valueOf(b / a));
            } else {
                stack.offer(ch);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
