package org.kaidzen.study.leetcode.y2023_2024.graph.topologySort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Find if all courses can be finished, using adjacency list
 */
public class CourseSchedule_207_v2 {

    public static void main(String[] args) {
        CourseSchedule_207_v2 courses = new CourseSchedule_207_v2();
//        int[][] prerequisits = new int[][]{{1,0},{0,1}};
//        final boolean could = courses.canFinish(2, prerequisits);
//        System.out.println(could);
        int[][] prerequisits = new int[][]{{1, 0}};
        final boolean could = courses.canFinish(2, prerequisits);
        System.out.println(could);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());

        }
        for (int[] prereq : prerequisites) {
            adjacency.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (queue.peekFirst() != null) {
            Integer node = queue.pollFirst();
            visited++;
            for (Integer neighbor : adjacency.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return numCourses == visited;
    }
}
