package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {

    public int[][] kClosest1(int[][] points, int K) {
        Comparator<int[]> comparator = (p1, p2) -> (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);

        Arrays.sort(points, comparator);
        int[][] result = new int[K][];
        for (int i = 0; i < K; i++) {
            result[i] = points[i];
        }
        return result;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin closestPoint = new KClosestPointsToOrigin();
//        Input: points = [[1,3],[-2,2]], K = 1
//        Output: [[-2,2]]
//        Explanation:
//        (Here, the distance between two points on a plane is the Euclidean distance.)
//        The distance between (1, 3) and the origin is sqrt(10).
//        The distance between (-2, 2) and the origin is sqrt(8).
//        Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//        We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

        System.out.println(Arrays.deepToString(closestPoint.kClosest1(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }
}
