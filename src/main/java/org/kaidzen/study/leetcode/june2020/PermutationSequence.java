package org.kaidzen.study.leetcode.june2020;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        int[] factorial = new int[n];
        factorial[0] = 1;

        //Calculate factorial
        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        //To convert to zero-based calculations
        k = k - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(list.get(index));
            list.remove(index);
            k = k % factorial[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        Input: n = 3, k = 3
//        Output: "213"
        PermutationSequence sequence = new PermutationSequence();
        System.out.println(sequence.getPermutation(3, 3));
    }
}
