package org.kaidzen.study.leetcode.y2023_2024.array;

import java.util.*;

public class TopKFrequenElements {

    public static void main(String[] args) {
        TopKFrequenElements elements = new TopKFrequenElements();
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(elements.topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num: nums){
            counts.merge(num, 0, (a,b) -> a+1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key: counts.keySet()){
            int frequency = counts.get(key);
            if (bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for(int idx = bucket.length-1; idx >= 0; idx--){
            if (bucket[idx] != null){
                for(int i=0; i < bucket[idx].size() && result.size() < k; i++){
                    result.add(bucket[idx].get(i));
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i=0; i<result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }
}
