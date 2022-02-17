package org.kaidzen.study.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Queue<Character> sortedFromMax = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        sortedFromMax.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while (!sortedFromMax.isEmpty()) {
            char current = sortedFromMax.remove();
            for (int i = 0; i < map.get(current); i++) {
                sb.append(current);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency sort = new SortCharactersByFrequency();
//        Input:
//        "tree"
//
//        Output:
//        "eert"
//
//        Explanation:
//        'e' appears twice while 'r' and 't' both appear once.
//                So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

        System.out.println(sort.frequencySort("tree"));
    }
}
