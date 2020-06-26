package org.kaidzen.study.leetcode.june2020;

import java.util.HashMap;
import java.util.Map;

public class FindTheDuplicateNumber {

    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        int maxIdx = 0;
        int currentMax = 0;
        //As values in array within range 1..n, we will
        // take value and modify number, that referenced by this value
        for (int i=0; i < n; i++){
            //Modulo of size will keep as in range array length
           int id = nums[i] % n;
           //Modification done by add current "constant" - length of array
           nums[id] += n;
        }
        for (int i=0; i < n; i++){
            //Travers modified array to find max value
            if (nums[i] > currentMax){
                currentMax = nums[i];
                //Take index of current maximum value
                maxIdx = i;
            }
            //Clean out modification, that done with "constant"
            nums[i] %= n;
        }
        return maxIdx;
    }

    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.merge(n, 1, (old, fresh) -> old += 1);
        }
        return map.entrySet().parallelStream()
                .filter(entry -> entry.getValue() > 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber duplicates = new FindTheDuplicateNumber();
//        Input: [1,3,4,2,2]
//        Output: 2
        System.out.println(duplicates.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(duplicates.findDuplicate2(new int[]{1, 3, 4, 2, 2}));
    }
}
