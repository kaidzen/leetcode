package org.kaidzen.study.leetcode;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() == 0) {
            return false;
        }
        int[] chars = new int[26];
        for (char ch : s1.toCharArray()) {
            chars[ch - 'a']++;
        }
        int left = 0;
        int rigth = 0;
        int count = s1.length();
        int permutations = 0;
        while (rigth < s2.length()) {
            if (chars[s2.charAt(rigth++) - 'a']-- >= 1) {
                count--;
            }
            if (count == 0) {
                permutations++;
            }
            if (rigth - left == s1.length() && chars[s2.charAt(left++) - 'a']++ >= 0) {
                count++;
            }
        }
        return permutations > 0;
    }

    public static void main(String[] args) {


        PermutationInString permutation = new PermutationInString();
//        Input: s1 = "ab" s2 = "eidbaooo"
//        Output: True
//        Explanation: s2 contains one permutation of s1 ("ba").
        System.out.println(permutation.checkInclusion("ab", "eidbaooo"));
    }
}
