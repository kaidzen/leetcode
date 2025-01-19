package org.kaidzen.study.leetcode.y2023_2024.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestReplaced = new LongestRepeatingCharacterReplacement();

        String str = "ABAB";
        /*
        int k = 2;
        System.out.println(longestReplaced.characterReplacement(str, k)); //4
        */

        String str2 = "AABABBA";
        int k2 = 1;
        System.out.println(longestReplaced.characterReplacement(str2, k2)); //4

    }

    /**
     * Return the length of the longest substring containing the same letter you can get after performing the above operations.
     *
     * @param s target string
     * @param k allowed replacements
     * @return the longest substring
     */
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int result = 0;
        int l = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            final char ch = s.charAt(r);
            count[ch - 'A']++;
            maxFreq = Math.max(maxFreq, count[ch - 'A']);
            if ((r - l + 1) - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
