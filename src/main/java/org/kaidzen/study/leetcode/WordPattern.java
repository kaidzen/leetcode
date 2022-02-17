package org.kaidzen.study.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        WordPattern checkPattern = new WordPattern();
//        Input: pattern = "abba", str = "dog cat cat dog"
//        Output: true
        System.out.println(checkPattern.wordPattern("abba", "dog cat cat dog"));

//        Input:pattern = "abba", str = "dog cat cat fish"
//        Output: false
        System.out.println(checkPattern.wordPattern("abba", "dog cat cat fish"));
    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (!map.containsKey(c) && !map.containsValue(word)) {
                map.put(c, word);
            }
            if (!word.equals(map.get(c))) {
                return false;
            }
        }
        return true;
    }
}
