package org.kaidzen.study.leetcode.y2025.strings;

/**
 * Two pointer approach
 * T = O(n)
 * S = O(1)
 */
public class IsSubsequence_392 {

    public static void main(String[] args) {
        IsSubsequence_392 isS = new IsSubsequence_392();

        String s ="aaaaaa";
        String t = "bbaaaa";
        System.out.println(isS.isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        int s1 = s.length();
        int t1 = t.length();

        if (s.isEmpty()) return true;

        if(!t.contains(String.valueOf(s.charAt(0))) || s1 > t1 ) {
            return false;
        }


        int k = 0;
        for (int i = 0; i < t1; i++) {
            final char c = s.charAt(k);
            if (t.charAt(i) == c) {
                if (k == s1 -1) {
                    return true;
                } else {
                    k++;
                }
            }
        }
        return false;
    }
}
