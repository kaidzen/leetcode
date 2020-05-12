package org.kaidzen.study.leetcode;

import java.util.Arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) { return image;}
        dfsFill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfsFill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color){
            return;
        }
        image[sr][sc] = newColor;
        dfsFill(image, sr-1, sc, color, newColor);
        dfsFill(image, sr+1, sc, color, newColor);
        dfsFill(image, sr, sc-1, color, newColor);
        dfsFill(image, sr, sc+1, color, newColor);
    }

    public static void main(String[] args) {
        FloodFill painter = new FloodFill();

    //  Input:
    //  image = [[1,1,1],[1,1,0],[1,0,1]]
    //  sr = 1, sc = 1, newColor = 2
    //  Output: [[2,2,2],[2,2,0],[2,0,1]]
        int[][] image1 = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(Arrays.deepToString(painter.floodFill(image1, 1, 1, 2)));
    }
}
