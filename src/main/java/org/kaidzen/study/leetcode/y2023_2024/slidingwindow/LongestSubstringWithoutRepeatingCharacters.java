package org.kaidzen.study.leetcode.y2023_2024.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters withoutRepeating = new LongestSubstringWithoutRepeatingCharacters();

        String s = "abcabcbb";
        System.out.println(withoutRepeating.lengthOfLongestSubstring(s));

        String s2 = "pwwkew";
        System.out.println(withoutRepeating.lengthOfLongestSubstring(s2));
    }

    public int lengthOfLongestSubstring(String s) {
        int theLongest = 0;
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        while (r < length){
            while (set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            theLongest = Math.max(theLongest, r-l+1);
            r++;
        }

        return theLongest;
    }
}
