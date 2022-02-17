package org.kaidzen.study.leetcode;

public class PointsOnStraitLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        if (length == 0) {
            return false;
        } else if (length == 2) {
            return true;
        }
        double x1 = coordinates[0][0];
        double y1 = coordinates[0][1];

        Double slope = null;
        for (int i = 1; i < length; i++) {
            double x2 = coordinates[i][0];
            double y2 = coordinates[i][1];

            if (x2 - x1 == 0) {
                return false;
            }
            if (slope == null) {
                slope = (y2 - y1) / (x2 - x1);
                continue;
            }
            double currentSlope = (y2 - y1) / (x2 - x1);
            if (slope != currentSlope) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//        Output: true
        PointsOnStraitLine points = new PointsOnStraitLine();
        int[][] array1 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(points.checkStraightLine(array1));
//        Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//        Output: false
        int[][] array2 = new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        System.out.println(points.checkStraightLine(array2));
    }
}
