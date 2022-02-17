package org.kaidzen.study.leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        List<Pair<String, String>> list = Arrays.asList(
                new Pair<>("ab#c", "ad#c"),
                new Pair<>("ab##", "c#d#"),
                new Pair<>("a##c", "#a#c"),
                new Pair<>("a#c", "b")
        );
        BackspaceStringCompare comparator = new BackspaceStringCompare();

        list.forEach(pair -> System.out.println(comparator.backspaceCompare(pair.getKey(), pair.getValue())));
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = storeChars(S);
        Stack<Character> tStack = storeChars(T);

        while (!sStack.isEmpty()) {
            char current = sStack.pop();
            if (tStack.isEmpty() || tStack.pop() != current) {
                return false;
            }
        }
        return sStack.isEmpty() && tStack.isEmpty();
    }

    private Stack<Character> storeChars(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch != '#') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack;
    }
}
