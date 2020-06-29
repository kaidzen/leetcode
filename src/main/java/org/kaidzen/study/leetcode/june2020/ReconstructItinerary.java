package org.kaidzen.study.leetcode.june2020;

import java.util.*;

public class ReconstructItinerary {

    private Deque<String> stack = new LinkedList<>();
    private Map<String, Queue<String>> adjList = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //Prepare adjacent list with all combination
        for (List<String> pair : tickets) {
            String from = pair.get(0);
            adjList.putIfAbsent(from, new PriorityQueue<>(String::compareTo));
            adjList.get(from).add(pair.get(1));
        }
        String startPoint = "JFK";
        dfs(startPoint);
        return new ArrayList<>(stack);
    }

    private void dfs(String city) {
        Queue<String> queue = adjList.get(city);
        while (Objects.nonNull(queue) && !queue.isEmpty()){
            //Each first in queue will be taken for search by dfs
            String firstAdjacent = queue.poll();
            dfs(firstAdjacent);
        }
        //And add it to result in revers order.
        stack.addFirst(city);
    }

    public static void main(String[] args) {
        ReconstructItinerary itinerary = new ReconstructItinerary();
//        Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//        Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
        List<List<String>> tickets1 = Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        );
        List<String> res = itinerary.findItinerary(tickets1);
        System.out.println(res);
//        Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//        Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//        Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
//        But it is larger in lexical order.
        List<List<String>> tickets2 = Arrays.asList(
                Arrays.asList("JFK","SFO"),
                Arrays.asList("JFK","ATL"),
                Arrays.asList("SFO","ATL"),
                Arrays.asList("ATL","JFK"),
                Arrays.asList("ATL","SFO")
        );
        List<String> res2 = itinerary.findItinerary(tickets2);
        System.out.println(res2);
    }
}
