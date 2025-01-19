package org.kaidzen.study.leetcode.y2023_2024.graph.adjacencyList;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Find if all courses can be finished, using adjacency list
 */
public class CourseSchedule_207 {

    public static void main(String[] args) {
        CourseSchedule_207 courses = new CourseSchedule_207();
        int[][] prerequisits = new int[][]{{1,0},{0,1}};
        final boolean could = courses.canFinish(2, prerequisits);
        System.out.println(could);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqMap = IntStream.range(0, numCourses).boxed()
                .collect(Collectors.toMap(Function.identity(), ArrayList::new));
        final Map<Integer, List<Integer>> collect = Arrays.stream(prerequisites)
                .collect(Collectors.toMap(
                        arr -> arr[0],
                        arr -> {
                            List<Integer> list = new ArrayList<>();
                            list.add(arr[1]);
                            return list;
                        },
                        (oldList, newList) -> {
                            oldList.addAll(newList);
                            return oldList;
                        }
                ));
        System.out.println(collect);
        Set<Integer> visited = new HashSet<>();

        List<Boolean> match = prereqMap.keySet()
                .stream()
                .map(course -> dfsSearch(course, visited, collect))
                .collect(Collectors.toList());
        return match.stream()
                .noneMatch(Boolean.FALSE::equals);
    }

    private boolean dfsSearch(Integer course, Set<Integer> visited, Map<Integer, List<Integer>> prereqMap) {
        if (visited.contains(course)) {
            return false;
        } else if (prereqMap.getOrDefault(course, new ArrayList<>()).isEmpty()) {
            return true;
        }
        visited.add(course);
        for (Integer pre : prereqMap.get(course)) {
            if (!dfsSearch(pre, visited, prereqMap)) return false;
        }
        visited.remove(course);
        prereqMap.put(course, new ArrayList<>());

        return true;
    }
}
