package org.kaidzen.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartition {

    private boolean possibleBipartition(int N, int[][] dislikes) {
        int[] groups = new int[N];
        Arrays.fill(groups, -1);
        ArrayList[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            adj[p[0] - 1].add(p[1] - 1);
            adj[p[1] - 1].add(p[0] - 1);
        }
        for (int i = 0; i < N; i++) {
            if (groups[i] == -1 && !dfs(adj, groups, i, 0)) {
                return false;
            }
        }
        return true;
    }
k
    private boolean dfs(List<Integer>[] adj, int[] groups, int v, int group){
        if (groups[v] == -1){
            groups[v] = group;
        } else {
            return groups[v] == group;
        }
        for (int n: adj[v]){
            if (!dfs(adj, groups, n, 1 - group)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition biPartitioned = new PossibleBipartition();
//        Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
////        Output: true
////        Explanation: group1 [1,4], group2 [2,3]
        System.out.println(biPartitioned.possibleBipartition(4, new int[][]{{1,2},{1,3},{2,4}}));
    }
}
