package org.kaidzen.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContiguosArray {

    public int findMaxLength(int[] nums) {
        int maxSum = 0;
        int currentSum = 0;
        Map<Integer, Integer> track = new HashMap<>();

        track.put(0, -1);

        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i] == 0 ? -1 : nums[i]; //calculate balance of array's elements
            if(track.containsKey(currentSum)){
                maxSum = Math.max(maxSum, i - track.get(currentSum));
            } else {
                track.put(currentSum, i);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        List<int[]> list = Arrays.asList(
                new int[]{0, 1},
                new int[]{0, 1, 0}
        );
        ContiguosArray contiguos = new ContiguosArray();
        list.forEach(ints -> System.out.println(contiguos.findMaxLength(ints)));
    }
}
