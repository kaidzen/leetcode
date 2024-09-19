package org.kaidzen.study.codesignal;

import java.util.ArrayDeque;
import java.util.Deque;

public class AreSimilar {

    public static void main(String[] args) {
        AreSimilar areIt = new AreSimilar();

        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{2, 1, 3};
        System.out.println(areIt.solution(a, b));
    }

    boolean solution(int[] a, int[] b) {

        if (a == null || a.length != b.length || b == null) {
            return false;
        }

        Deque<Integer> indStk = new ArrayDeque<>();
        int diff = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (indStk.isEmpty()) {
                    indStk.push(i);
                    diff++;
                } else if (a[i] == b[indStk.peek()] && b[i] == a[indStk.peek()]) {
                    indStk.pop();
                }
            }
            if (diff > 1) return false;
        }
        return indStk.isEmpty();
    }
}
