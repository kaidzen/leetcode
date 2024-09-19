package org.kaidzen.study.leetcode.y2023_2024.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku sudoku = new ValidSudoku();
        char[][] board = new char[][]{
                  {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(sudoku.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {

        //Storing unique strings for each validity rules for Sudoku
        //1- unique int the row, 2 - unique in the column, 3 - unique within box (3x3)
        Set<String> set = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char cur = board[row][col];
                if (cur != '.'){
                    if (!set.add(cur + "row" + row)) return false;
                    if (!set.add(cur + "col" + col)) return false;
                    if (!set.add(cur + "box" + row/3 + col/3)) return false;
                }

            }
        }
        return true;
    }

}
