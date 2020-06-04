package org.kaidzen.study.leetcode.june2020;

import java.util.Arrays;

public class TwoCitySheduling {

    public int twoCitySchedCost(int[][] costs) {
        //Sort out array, based on comparator of pair "common value".
        Arrays.sort(costs, (a, b) -> {return (a[0] -a[1]) - (b[0] - b[1]);});
        int totalCost = 0;
//        //As costs is even and sorted, first half of it will be with smallest A's
//        for (int i=0; i<costs.length/2; i++){
//            totalCost += costs[i][0];
//        }
//        //And second part is with B's smallest values
//        for (int i=costs.length/2; i<costs.length; i++){
//            totalCost += costs[i][1];
//        }
        //Optimized for better presentation
        int half = costs.length/2;
        for (int i=0; i<half; i++){
            totalCost += costs[i][0] + costs[i+half][1];
        }
        //Return sum of coefficients() of A - B totalCost values
        return totalCost;
    }

    public static void main(String[] args) {
//        Input: [[10,20],[30,200],[400,50],[30,20]]
//        Output: 110
//        Explanation:
//        The first person goes to city A for a cost of 10.
//        The second person goes to city A for a cost of 30.
//        The third person goes to city B for a cost of 50.
//        The fourth person goes to city B for a cost of 20.
//
//        The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
        TwoCitySheduling schedule = new TwoCitySheduling();
        int result = schedule.twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}});
        System.out.println(result);
    }
}
