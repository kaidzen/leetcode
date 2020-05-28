package org.kaidzen.study.leetcode;

public class UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dpMatrix = new int[m+1][n+1];

        for (int i=1; i<m+1; i++){
            for (int j=1; j<n+1; j++){
                dpMatrix[i][j] = (A[i-1] == B[j-1]) ? 1 + dpMatrix[i-1][j-1] :
                        Math.max(dpMatrix[i][j-1], dpMatrix[i-1][j]);
            }
        }
        return dpMatrix[m][n];
    }

    public static void main(String[] args) {
        UncrossedLines crossedLines = new UncrossedLines();
//        Input: A = [1,4,2], B = [1,2,4]
//        Output: 2
//        Explanation: We can draw 2 uncrossed lines as in the diagram.
        System.out.println(crossedLines.maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
    }
}
