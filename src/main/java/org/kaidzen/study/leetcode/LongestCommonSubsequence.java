package org.kaidzen.study.leetcode;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0)
            return 0;
        if (text1.charAt(0) == text2.charAt(0)) {
            return 1 + lcsTable(text1.substring(1), text2.substring(1));
        }
        return Math.max(lcsTable(text1.substring(1), text2), lcsTable(text1, text2.substring(1)));
    }

    private int lcsTable(String text2, String text1) {
        int m = text2.length();
        int n = text1.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 0;
        for (int i = 0; i < dp[0].length; i++)
            dp[0][i] = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text2.charAt(i - 1) == text1.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        String[] arr1 = new String[]{"abcde", "ace"};

        LongestCommonSubsequence subsequence = new LongestCommonSubsequence();
        System.out.println(subsequence.longestCommonSubsequence(arr1[0], arr1[1]));
    }
}
