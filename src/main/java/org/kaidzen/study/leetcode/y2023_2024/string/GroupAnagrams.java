package org.kaidzen.study.leetcode.y2023_2024.string;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();

        String[] strs = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};
//        System.out.println(anagrams.group(strs));
        System.out.println(anagrams.group2(strs));
    }

    public List<List<String>> group(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String st : strs) {
            final char[] charArray = st.toCharArray();
            Arrays.sort(charArray);

            String sortedStr = new String(charArray);
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(st);

        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> group2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String st : strs) {
            final int[] counts = new int[26];
            for (char ch : st.toCharArray()) {
                counts[ch - 'a']++;
            }
            String key = Arrays.toString(counts);

//            String sortedStr = new String(counts);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(st);

        }
        return new ArrayList<>(map.values());
    }
}
