package org.kaidzen.study.leetcode.june2020;

public class SurroundedRegions {

    public void solve(char[][] board) {
        int rows = board.length;
        if (rows <=2 ){ return;}
        int cols = board[0].length;
        if (cols <=2 ){ return;}
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (board[i][j] == 'O' && (i == 0 || i == rows-1 || j == 0 || j == cols-1)){
                    dfs(board, i, j);
                }
            }
        }
        for (int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i >= 0 &&  i<board.length && j >= 0 && j < board[0].length && board[i][j] == 'O'){
            board[i][j] = 'A';
            dfs(board, i+1, j);
            dfs(board, i-1, j);
            dfs(board, i, j+1);
            dfs(board, i, j-1);
        }
    }

    public static void main(String[] args) {

    }
}
