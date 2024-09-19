package org.kaidzen.study.leetcode.y2023_2024.array;

import org.kaidzen.study.leetcode.util.ResourceFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram anagram = new ValidAnagram();

//        String s = "anagram", t = "nagaram";
//        System.out.println(anagram.isAnagram(s, t));
//
//        String s1 = "car", t1 = "cat";
//        System.out.println(anagram.isAnagram(s1, t1));

        String sFile = "annagram/s.txt";
        String tFile = "annagram/t.txt";

        String s2 = ResourceFile.listFromFile(sFile).stream().reduce((a, b) -> a+b).orElseGet(() -> "");
        String t2 = ResourceFile.streamFromFile(tFile).stream().reduce((a, b) -> a+b).orElseGet(() -> "");
        System.out.println(anagram.isAnagram(s2, t2));
        System.out.println(anagram.isAnagram2(s2, t2));
    }

    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) return false;

        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < sLength; i++) {
            countS.merge(s.charAt(i), 1, Integer::sum);
            countT.merge(t.charAt(i), 1, Integer::sum);
        }
        for (char ch : countS.keySet()) {
            if (!countS.get(ch).equals(countT.getOrDefault(ch, 0))) return false;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        int length = s.length();
        if (length != t.length()) return false;
        final List<String> sortedS = s.chars()
                .mapToObj(String::valueOf)
                .sorted()
                .collect(Collectors.toList());
        final List<String> sortedT = t.chars()
                .mapToObj(String::valueOf)
                .sorted()
                .collect(Collectors.toList());
        for (int i = 0; i < length; i++) {
            if (!sortedS.get(i).equals(sortedT.get(i))){
                return false;
            }
        }
        return true;
    }
}
