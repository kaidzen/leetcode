package org.kaidzen.study.leetcode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        List<Character> jewelsList = J.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.toList());
        int result = 0;
        for (char ch : S.toCharArray()) {
            if (jewelsList.contains(ch)) {
                result++;
            }
        }
        return result;
    }

    public int numJewelsInStones2(String J, String S) {
        Map<Character, Integer> jewelsList = J.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.toMap(k -> k, v -> 1));
        int result = 0;
        for (char ch : S.toCharArray()) {
            if (jewelsList.getOrDefault(ch, 0) == 1) {
                result++;
            }
        }
        return result;
    }

    public int numJewelsInStones3(String J, String S) {
        int[] alphabet = new int[256];
        for (char ch : S.toCharArray()) {
            alphabet[ch]++;
        }
        int result = 0;
        for (char ch : J.toCharArray()) {
            result += alphabet[ch];
        }
        return result;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        JewelsAndStones jewels = new JewelsAndStones();

        System.out.println(jewels.numJewelsInStones3(J, S));
    }
}
