package org.kaidzen.study.leetcode.y2025.strings;

/**
 * Two pointers approach.
 * T = O(n)
 * S = O(1)
 */
public class ValidPalindrome_125 {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        int len = s.length();
        if (s.isEmpty() || len == 1) return true;

        int l = 0;
        int r = len - 1;

        while (l < r) {
            while (l < r &&  l < len && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while ( r > l && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (s.charAt(l) != s.charAt(r)) {

                return false;
            }
            System.out.println(s.charAt(l) + " and " + s.charAt(r));
            l++;
            r--;
        }
        return true;
    }
}
