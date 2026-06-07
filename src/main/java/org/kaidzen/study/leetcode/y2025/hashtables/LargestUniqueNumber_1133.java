package org.kaidzen.study.leetcode.y2025.hashtables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, return the largest integer that only occurs once. If no integer
 * occurs once, return -1.
 *
 * Example 1:
 * Input: nums = [5,7,3,9,4,9,8,3,1]
 * Output: 8
 * Explanation: The maximum integer in the array is 9 but it is repeated. The number 8 occurs
 * only once, so it is the answer.
 *
 *  Example 2:
 * Input: nums = [9,9,8,8]
 * Output: -1
 * Explanation: There is no number that occurs only once.
 *
 * Constraints:
 * 1 <= nums.length <= 2000
 * 0 <= nums[i] <= 1000
 */
public class LargestUniqueNumber_1133 {
    public int largestUniqueNumber(int[] nums) {
        int res = -1;
        Map<Integer,Integer> seen = new HashMap<>();

        for (int num : nums) {
            seen.merge(num, 1, Integer::sum);
        }
        List<Integer> keys = seen.entrySet().stream()
                .filter(ent -> ent.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(seen);
        System.out.println(keys);
        for (int key : keys) {
            res = Math.max(res, key);
        }

        return res;
    }
}
