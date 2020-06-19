package org.kaidzen.study.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] array2 = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        String[] array3 = {"banan", "anban"};
        GroupAnagrams grouper = new GroupAnagrams();
        System.out.println(grouper.groupAnagrams(array3));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new ArrayList<>(Arrays.asList(strs)).stream()
                .collect(Collectors.groupingBy(this::calculateAnagramHash, HashMap::new,
                        Collectors.mapping(Function.identity(), Collectors.toList())));
        result.forEach(
                (s, strings) -> System.out.println("Key: " +s+ "value: " +strings)
        );
        return result.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    private String calculateAnagramHash(String str) {
        int[] alphabet = new int[26];
        for (char ch : str.toCharArray()) {
            alphabet[ch - 'a']++;
        }
        return Arrays.toString(alphabet);
    }
}
