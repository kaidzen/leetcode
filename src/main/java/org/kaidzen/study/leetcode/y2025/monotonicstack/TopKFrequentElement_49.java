package org.kaidzen.study.leetcode.y2025.monotonicstack;

import java.util.*;

/**
 *
 */
public class TopKFrequentElement_49 {

    public static void main(String[] args) {
        TopKFrequentElement_49 topK = new TopKFrequentElement_49();

        int[] nums = new int[]{};
        int k = 3;
                ;
        System.out.println(Arrays.toString(topK.topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
                (a,b) -> map.get(a) - map.get(b)
        );

        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
