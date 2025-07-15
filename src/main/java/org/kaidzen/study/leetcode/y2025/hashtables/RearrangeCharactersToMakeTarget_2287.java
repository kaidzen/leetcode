package org.kaidzen.study.leetcode.y2025.hashtables;

/**
 * Counting characters. Then for each char from target, looking for min count.
 * Repetition of characters in the target resolved by evaluating quotient of each
 * character in the source and the target.
 */
public class RearrangeCharactersToMakeTarget_2287 {

    public static void main(String[] args) {
        RearrangeCharactersToMakeTarget_2287 make = new RearrangeCharactersToMakeTarget_2287();

        String s = "ilovecodingonleetcode";
        String t = "code";
        System.out.println(make.rearrangeCharacters(s, t)); // 2

        String s1 = "abbaccaddaeea";
        String t1 = "aaaaa";
        System.out.println(make.rearrangeCharacters(s1, t1)); // 1
    }

    public int rearrangeCharacters(String s, String target) {
        int[] chars = new int[26];
        for (char ch: s.toCharArray()) {
            chars[ch -'a']++;
        }
        int[] charsT = new int[26];
        for (char ch: target.toCharArray()) {
            charsT[ch -'a']++;
        }

        final int first = target.charAt(0) - 'a';
        int min = Math.floorDiv(chars[first], charsT[first]);

        for (int i=1; i < target.length(); i++) {
            final int cur = target.charAt(i) - 'a';
            min = Math.min(min, Math.floorDiv(chars[cur], charsT[cur]));
        }
        return min;
    }

}
