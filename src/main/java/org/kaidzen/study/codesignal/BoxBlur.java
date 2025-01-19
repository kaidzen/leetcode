package org.kaidzen.study.codesignal;

import java.util.Arrays;

public class BoxBlur {

    public static void main(String[] args) {
        BoxBlur bb = new BoxBlur();

        int[][] image = new int[][]{{1,1,1},
                {1,7,1},
                {1,1,1}};
        final int[][] res = bb.solution(image);
        System.out.println(Arrays.deepToString(res));
    }

    int[][] solution(int[][] image) {
        int row = image.length;
        int col = image[0].length;
        int[][] blur = new int[row - 2][col - 2];

        for (int r = 1; r < row - 1; r++) {
            for (int c = 1; c < col - 1; c++) {
                blur[r-1][c-1] = getAvg(image, r, c);
            }
        }

        return blur;
    }

    private int getAvg(int[][] img, int row, int col) {
        /*
            ul -1, -1
            um -1, 0
            ur -1, +1
            ml 0, -1
            mm 0, 0
            mr 0, +1
            dl +1, -1
            dm +1, 0
            dr +1, +1
         */
        return (img[row-1][col-1] + img[row-1][col] + img[row-1][col+1] +
                img[row][col-1] + img[row][col] + img[row][col+1] +
                img[row+1][col-1] + img[row+1][col] + img[row+1][col+1]
        )/9;
    }
}
