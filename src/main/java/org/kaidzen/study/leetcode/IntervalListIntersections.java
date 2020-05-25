package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int pointerA = 0;
        int pointerB = 0;
        int sizeA = A.length;
        int sizeB = B.length;
        Deque<int[]> result = new LinkedList<>();
        while (pointerA<sizeA && pointerB<sizeB){
            if (B[pointerB][0] <= A[pointerA][1] && A[pointerA][0] <= B[pointerB][1]){
                result.addLast(new int[]{
                        Math.max(A[pointerA][0], B[pointerB][0]),
                        Math.min(A[pointerA][1], B[pointerB][1]),
                });
            }
            if (A[pointerA][1] > B[pointerB][1]){
                pointerB++;
            } else {
                pointerA++;
            }
        }
        return result.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
//        Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
//        Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        IntervalListIntersections intervalIntersection = new IntervalListIntersections();
        int[][] res = intervalIntersection.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        System.out.println(Arrays.deepToString(res));
    }
}
