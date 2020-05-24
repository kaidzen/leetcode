package org.kaidzen.study.leetcode;

public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] additive = new int[row][col];
        int count = 0;
        for (int i = 0; i < col; i++) // fill out additive with 1-th row of matrix, and counting "1"
        {
            additive[0][i] = matrix[0][i];
            count += additive[0][i];
        }
        for (int i = 1; i < row; i++) // fill out additive with 1-th column of matrix, and counting "1"
        {
            additive[i][0] = matrix[i][0];
            count += additive[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //check if it contain with "1"
                if (matrix[i][j] == 1) {
                    //Fill out additive with minimum of right bottom corner's neighbours
                    additive[i][j] = 1 + Math.min(
                            additive[i - 1][j], Math.min(additive[i - 1][j - 1], additive[i][j - 1]));
                    //Count all other found square matrix
                    count += additive[i][j];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountSquareSubmatricesWithAllOnes counter = new CountSquareSubmatricesWithAllOnes();
//        Input: matrix =
//[
//  [0,1,1,1],
//  [1,1,1,1],
//  [0,1,1,1]
//]
//        Output: 15
//        There are 10 squares of side 1.
//        There are 4 squares of side 2.
//        There is  1 square of side 3.
//        Total number of squares = 10 + 4 + 1 = 15.
//    }
        int[][] array1 = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println(counter.countSquares(array1));
//        Input: matrix =
//[
//  [1,0,1],
//  [1,1,0],
//  [1,1,0]
//]
//        Output: 7
//        There are 6 squares of side 1.
//        There is 1 square of side 2.
//        Total number of squares = 6 + 1 = 7.
        int[][] array2 = new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(counter.countSquares(array2));
    }
}
