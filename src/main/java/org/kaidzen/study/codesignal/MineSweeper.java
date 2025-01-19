package org.kaidzen.study.codesignal;

public class MineSweeper {

    public static void main(String[] args) {
        MineSweeper ms = new MineSweeper();


    }

    int[][] solution(boolean[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] minesM = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                minesM[r][c] = check(matrix, r, c);
            }
        }

        return minesM;
    }

    private int check(boolean[][] matrix, int r, int c) {
        int mines = 0;
        // define boundaries
        int up = r - 1 >= 0 ? r-1 : 0;
        int dn = r + 1 <= matrix.length-1 ? r+1 : matrix.length-1;
        int lf = c - 1 >= 0 ? c - 1 : 0;
        int rt = c + 1 <= matrix[0].length - 1 ? c + 1 : matrix[0].length - 1;
        for (int i = up; i <= dn; i++) {
            for (int j = lf; j <= rt; j++) {
               if (matrix[i][j] && !(r == i && c == j)) {
                   mines++;
               }
            }
        }

        return mines;
    }
}
