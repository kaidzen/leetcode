package org.kaidzen.study.leetcode.y2025.hashtables;

import java.util.*;

/**
 * Grouping based on the proper key creation, chosen for HashMap
 *
 */
public class GroupAnagrams_49 {

    public static void main(String[] args) {
        GroupAnagrams_49 group = new GroupAnagrams_49();

        String[] array = new String[]{"bdddddddddd","bbbbbbbbbbc"};
        System.out.println(group.groupAnagrams(array)); // [["bbbbbbbbbbc"],["bdddddddddd"]]
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {

            List<String> base = new ArrayList<>();
            base.add(str);
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String key = new String(sorted);
            map.merge(key, base, (b1, b2) -> {
                b1.addAll(b2);
                return b1;
            });
        }
        return map.values().stream().toList();
    }
}
