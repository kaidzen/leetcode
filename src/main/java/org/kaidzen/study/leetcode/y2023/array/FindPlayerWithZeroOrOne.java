package org.kaidzen.study.leetcode.y2023.array;

import java.util.*;

public class FindPlayerWithZeroOrOne {

    public static void main(String[] args) {
        FindPlayerWithZeroOrOne players = new FindPlayerWithZeroOrOne();
        int[][] matches = new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(players.findWinners(matches));
        int[][] matches2 = new int[][]{{2,3},{1,3},{5,4},{6,4}};
        System.out.println(players.findWinners(matches2));
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> status = new HashMap<>();

        for (int[] pair : matches) {
            status.merge(pair[0], 1, (a, b) -> a);
            status.merge(pair[1], 0, (a, b) -> a - 1);
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> winner = new ArrayList<>();
        List<Integer> looser = new ArrayList<>();
        status.forEach((key, value) -> {
            if (value == 1) winner.add(key);
            if (value == 0) looser.add(key);
        });
        Collections.sort(winner);
        Collections.sort(looser);
        list.add(winner);
        list.add(looser);
        return list;
    }
}
