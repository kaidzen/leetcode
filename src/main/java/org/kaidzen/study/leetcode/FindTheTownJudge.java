package org.kaidzen.study.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheTownJudge {

    public int findJudge2(int N, int[][] trust) {
        int[] count = new int[N+1];
        for(int[] pair: trust){
            count[pair[0]]--;
            count[pair[1]]++;
        }
        for (int i=1; i<=N; i++){
            if (count[i] == N-1){ return i;}
        }
        return -1;
    }

    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0) { return 1;}
        int[] parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : trust) {
            int inhabitant = pair[0];
            int trustTo = pair[1];
            parents[inhabitant] = trustTo;
            map.computeIfAbsent(trustTo, val -> new ArrayList<>()).add(inhabitant);
        }
        for (Map.Entry<Integer, List<Integer>> listEntry : map.entrySet()) {
            List<Integer> members = listEntry.getValue();
            if (members.size() == N - 1) {
                int judge = listEntry.getKey();
                if (parents[judge] == judge) { return judge;}
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheTownJudge townJudge = new FindTheTownJudge();

    //        Input: N = 2, trust = [[1,2]]
    //        Output: 2
        int[][] trust = {{1, 2}};
        System.out.println(townJudge.findJudge(2, trust));

    //  Input: N = 3, trust = [[1,3],[2,3],[3,1]]
    //  Output: -1
        System.out.println(townJudge.findJudge(3, new int[][] {{1,3},{2,3},{3,1}}));

    //  Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
    //  Output: 3
        System.out.println(townJudge.findJudge2(4, new int[][] {{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }
}
