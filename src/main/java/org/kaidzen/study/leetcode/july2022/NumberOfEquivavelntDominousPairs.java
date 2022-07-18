package org.kaidzen.study.leetcode.july2022;

import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivavelntDominousPairs {

    public static void main(String[] args) {
        NumberOfEquivavelntDominousPairs equivalent = new NumberOfEquivavelntDominousPairs();

        int[][] dominoes = new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println("Domino's pairs: " + equivalent.numEquivDominoPairs(dominoes));
        System.out.println("Domino's pairs2: " + equivalent.numEquivDominoPairs2(dominoes));

        int[][] dominoes2 = new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};
        System.out.println("Domino's pairs: " + equivalent.numEquivDominoPairs(dominoes2));
        System.out.println("Domino's pairs2: " + equivalent.numEquivDominoPairs2(dominoes2));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] dominoe : dominoes) {
            int min = Math.min(dominoe[0], dominoe[1]);
            int max = Math.max(dominoe[0], dominoe[1]);

            int key = min * 10 + max;
            ans += map.getOrDefault(key, 0);
            map.put(key, 1 + map.getOrDefault(key, 0));
        }
        return ans;
    }

    public int numEquivDominoPairs2(int[][] dominoes) {
        int res = 0;
        int[][] counts = new int[10][10];
        for (int[] dominoe : dominoes) counts[dominoe[0]][dominoe[1]]++;
        for (int i = 1; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                if (i != j)
                    res += sum(counts[i][j] + counts[j][i]);
                else res += sum(counts[i][j]);
            }
        }
        return res;
    }

    public int sum(int n) {
        return n * (n - 1) / 2;
    }
}
