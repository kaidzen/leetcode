package org.kaidzen.study.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        for (int i = 0; i< length; i++){
            for (int j = i+1; j< length; j++){
                int sum = summIntervalOf(nums, i, j);
                if (sum == k){
                    result++;
                }
            }
        }
        return -1;
    }

    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int runningSumm = 0;
        map.put(0, 1);
        for (int num : nums) {
            runningSumm += num;
            if (map.containsKey(runningSumm - k)) {
                count += map.get(runningSumm - k);
            }
            map.put(runningSumm, map.getOrDefault(runningSumm, 0) + 1);
        }
        return count;
    }

    private int summIntervalOf(int[] nums, int i, int j) {
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,1,1};

        SubarraySumEqualsK subSumm = new SubarraySumEqualsK();

        System.out.println(subSumm.subarraySum2(arr1, 2));
    }
}
