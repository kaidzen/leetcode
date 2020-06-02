package org.kaidzen.leetcode;

import java.util.*;

public class LastStoneWeight {


    private static final Queue<Integer> queue = new PriorityQueue<>((x, y) -> y-x);

    public int lastStoneWeight(int[] stones) {
        for (int elem : stones) {
            queue.add(elem);
        }
        while (queue.size() >1){
            int y = queue.poll();
            int x = queue.poll();
            if (x == y){
            } else {
                queue.add(y-x);
            }
        }
        if (queue.peek() != null){
            return queue.poll();
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};

        LastStoneWeight laststone = new LastStoneWeight();
        System.out.println(laststone.lastStoneWeight(stones));
    }
}
