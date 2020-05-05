package org.kaidzen.study.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public int firstUniqChar3(String s) {
        int[] count = new int[26];

        for (char ch: s.toCharArray()) {
            count[ch -'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            map.merge(current, 1, (old, fresh) -> old+1 );
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == 1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            map.merge(current, i, (old, fresh) -> -1 );
        }

        int min = Integer.MAX_VALUE;
        for (char ch : s.toCharArray()) {
            Integer index = map.get(ch);
            if (index > -1 && index < min){
                min = index;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        //s = "leetcode" => 0
//        s = "loveleetcode" => 2

        FirstUniqueCharacter unique = new FirstUniqueCharacter();

        System.out.println(unique.firstUniqChar3("leetcode"));
        System.out.println(unique.firstUniqChar3("loveleetcode"));
    }
}
