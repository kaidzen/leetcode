package org.kaidzen.study.leetcode.y2025.strings;

/**
 * Simple one by one comparison.
 * Take first word as base and start to compare with each one character from all
 * words.
 * T = O(n * m) -> n: characters in the word, taken as base for comparison, m: amount of words
 * S = O(1)
 */
public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        LongestCommonPrefix_14 lcp = new LongestCommonPrefix_14();

        String[] arr = new String[] {"flower","flow","flight"};
        System.out.println(lcp.longestCommonPrefix(arr)); // "fl"

        String[] arr1 = new String[] {"ab","a"};
        System.out.println(lcp.longestCommonPrefix(arr1)); // "fl"
    }

    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        int len = str.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (String s: strs) {
                char ch = str.charAt(i);
                // check for word length
                if (i == s.length() || ch != s.charAt(i)) return result.toString();
            }
            result.append(str.charAt(i));
        }
        return result.toString();
    }
}
