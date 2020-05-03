package org.kaidzen.study.leetcode;

import java.util.Arrays;

public class MaximalSquareOfOnes {

    public int maxSquare1(char[][] matrix){
        if(matrix==null || matrix.length == 0 || matrix[0].length==0){
            return 0;
        }
        int[][] result = new int[matrix.length][matrix[0].length];
        int answer = 0;
        for(int x=0;x<result.length;x++){
            for(int y=0;y<result[0].length;y++){
                if(x==0||y==0){
                    if(matrix[x][y]=='1'){
                        answer = 1 ;
                        result[x][y]=1;
                    }
                    else{
                        result[x][y]=0;
                    }
                }
                if(matrix[x][y]=='1')
                    result[x][y]=1;
            }
        }
        for(int x=1;x<result.length;x++){
            for(int y=1;y<result[0].length;y++){
                if(matrix[x][y]=='1'){
                    result[x][y] = Math.min(result[x-1][y], Math.min(result[x][y-1],result[x-1][y-1])) +1;
                    answer = Math.max(answer,result[x][y]);
                }
            }
        }
        return answer*answer;
    }

    public static void main(String[] args) {
        MaximalSquareOfOnes squares = new MaximalSquareOfOnes();

        char[][] matrix = new char[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        squares.maxSquare1(matrix);
    }
}
