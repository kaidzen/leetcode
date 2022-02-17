package org.kaidzen.study.leetcode.june2020;

public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int x = 1; x <= n; x++) {
            int minVal = x;
            int y = 1;
            int square = 1;
            while (square <= x) {
                //Calculate all possible squares, that
                // less than current value (x)
                minVal = Math.min(minVal, 1 + dp[x - square]);
                y++;
                square = y * y;
            }
            //Fulfill the dp matrix
            dp[x] = minVal;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares findSquares = new PerfectSquares();
//        Input: n = 12
//        Output: 3
//        Explanation: 12 = 4 + 4 + 4.
        System.out.println(findSquares.numSquares(12));
    }
}
