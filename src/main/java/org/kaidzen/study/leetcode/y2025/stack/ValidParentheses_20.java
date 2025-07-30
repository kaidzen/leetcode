package org.kaidzen.study.leetcode.y2025.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Validate if Valid pairs of parentheses are provided.
 * Classical stack usage.
 * All open parentheses are added to stack, Then appropriate closed one take its pair from stack.
 * Success if pair is found and stack is empty.
 */
public class ValidParentheses_20 {

    public static void main(String[] args) {
        ValidParentheses_20 parenths = new ValidParentheses_20();

        String s = "([)]";
        System.out.println(parenths.isValid(s)); //false

        String s2 = "([])";
        System.out.println(parenths.isValid(s2)); //true
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }


}
