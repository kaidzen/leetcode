package org.kaidzen.study.leetcode;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null){return 0;}
        int columns = grid.length;
        int rows = grid[0].length;
        if (rows == 1){
            int sum = 0;
            for (int[] ints : grid) {
                sum += ints[0];
            }
            return sum;
        }

        int[][] dp = new int[columns][rows];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < columns; i++) { //fill top row
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j <rows ; j++) {   //fill first columns
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < columns; i++) {
            for (int j = 1; j < rows; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[columns-1][rows-1];
    }

    public static void main(String[] args) {
        int[][] map1 = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        MinPathSum minPath = new MinPathSum();

        System.out.println(minPath.minPathSum(map1));
    }
}
