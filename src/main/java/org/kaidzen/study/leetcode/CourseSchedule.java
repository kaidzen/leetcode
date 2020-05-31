package org.kaidzen.study.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        for (int i=0; i<numCourses; i++){
            adj.add(i, new ArrayList<>());
        }
        for (int[] pair: prerequisites){
            adj.get(pair[0]).add(pair[1]);
        }
        /*
        * Visited has 3 states:
        * 0 - not visited;
        * 1 - being visited;
        * 2 - completely visited;
         */
        int[] visited = new int[numCourses];
        for (int i=0; i<numCourses; i++){
            if (visited[i] == 0 && !dfs(adj, visited, i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<ArrayList<Integer>> adj, int[] visited, int v) {
        if (visited[v] == 1){
            return false;
        }
        visited[v] = 1;
        for(int neighbor: adj.get(v)){
            if (!dfs(adj,visited, neighbor)){
                return false;
            }
        }
        visited[v] = 2;
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule passCourse = new CourseSchedule();
//        Input: numCourses = 2, prerequisites = [[1,0]]
//        Output: true
//        Explanation: There are a total of 2 courses to take.
//                To take course 1 you should have finished course 0. So it is possible.
        System.out.println(passCourse.canFinish(2, new int[][]{new int[]{1,0}}));

//        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
////        Output: false
////        Explanation: There are a total of 2 courses to take.
////                To take course 1 you should have finished course 0, and to take course 0 you should
////        also have finished course 1. So it is impossible.
        System.out.println(passCourse.canFinish(2, new int[][]{new int[]{1,0}, new int[]{0,1}}));
    }
}
