package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParenthesis {

    public boolean checkValidString(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.charAt(0) == ')') {
            return false;
        }
        Stack<Integer> lefts = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == '(') {
                lefts.push(i);
            } else if (arr[i] == '*') {
                stars.push(i);
            } else {
                if (!lefts.empty()) {
                    lefts.pop();
                } else if (!stars.empty()) {
                    stars.pop();
                } else {
                    return false;
                }
            }
        }
        while (!lefts.empty()) {
            if (stars.empty()) {
                return false;
            } else if (lefts.peek() < stars.peek()) {
                lefts.pop();
                stars.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "()", "(*)", "(*))", "(((******))", "",
                "(())((())()()(*)(*()(())())())()()((()())((()))(*");
        ValidParenthesis validate = new ValidParenthesis();

        list.forEach(str -> System.out.println(validate.checkValidString(str)));
    }
}
