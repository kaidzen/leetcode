package org.kaidzen.study.leetcode.june2020;

public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] dpMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            dpMatrix[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dpMatrix[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpMatrix[i][j] = dpMatrix[i - 1][j] + dpMatrix[i][j - 1];
            }
        }
        return dpMatrix[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePath paths = new UniquePath();
//        Input: m = 3, n = 2
//        Output: 3
//        Explanation:
//        From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//        1. Right -> Right -> Down
//        2. Right -> Down -> Right
//        3. Down -> Right -> Right
        System.out.println(paths.uniquePaths(3, 2));
    }
}
