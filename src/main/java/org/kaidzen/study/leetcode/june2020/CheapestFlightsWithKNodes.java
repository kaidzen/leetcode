package org.kaidzen.study.leetcode.june2020;

import java.util.*;

public class CheapestFlightsWithKNodes {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights.length == 0) return -1;
        Map<Integer, List<int[]>> graph = new HashMap<>();

        //Initialise graph with presented values
        for (int[] flight : flights) {
            if (!graph.containsKey(flight[0])) {
                graph.put(flight[0], new ArrayList<>());
            }
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        //Use Minimal Priority queue.
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        q.add(new Node(src, 0, -1));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.city == dst) {
                return curr.cost;
            }
            //Check for given restriction about number of hops
            if (curr.stop < K) {
                List<int[]> nexts = graph.getOrDefault(curr.city, new ArrayList<>());

                //Add adjacent to the graph
                for (int[] next : nexts) {
                    q.add(new Node(next[0], curr.cost + next[1], curr.stop + 1));
                }
            }
        }
        return -1;
    }

    static class Node {
        int city;
        int cost;
        int stop;

        Node(int city, int cost, int stop) {
            this.city = city;
            this.cost = cost;
            this.stop = stop;
        }
    }

    public static void main(String[] args) {

    }
}
