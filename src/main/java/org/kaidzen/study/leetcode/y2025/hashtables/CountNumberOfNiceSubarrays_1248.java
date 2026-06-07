package org.kaidzen.study.leetcode.y2025.hashtables;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are
 * k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 * Example 1:
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 *
 *  Example 2:
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There are no odd numbers in the array.
 *
 *  Example 3:
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 */
public class CountNumberOfNiceSubarrays_1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int current = 0;
        Map<Integer,Integer> seen = new HashMap<>();
        seen.put(current, 1); // we should track all combination, so "we saw" 0 odds variant 1 time

        for (int i=0; i < nums.length; i++) {
            current += nums[i] % 2; //accumulating amount of odd elements
            ans += seen.getOrDefault(current - k, 0); // how many times we saw subarrays with k odds
//            seen.merge(current, 1, Integer::sum);
            seen.put(current, seen.getOrDefault(current, 0) + 1);
        }
        return ans;
    }

    /**
     * Use queue to store indexes of the odd numbers.
     * Use beginning and end of the queue according to the relation of the queue's size
     * to the provided k
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays2(int[] nums, int k) {
        int subArrs = 0;
        int lastPopped = -1;
        int initialGap = 0;
        Queue<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                indexes.offer(i);
            }
            if (indexes.size() > k) {
                lastPopped = indexes.poll();
            }
            if (indexes.size() == k) {
                initialGap = indexes.element() - lastPopped;
                subArrs += initialGap;
            }
        }
        return subArrs;
    }

    public int numberOfSubarrays3(int[] nums, int k) {
        int subArrs = 0;
        int qSize = 0;
        int initialGap = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                qSize++;
            }
            if (qSize == k) {
                initialGap = 0;
                while (qSize == k) {
                    qSize -= nums[start] % 2;
                    initialGap++;
                    start++;
                }
            }
            subArrs += initialGap;
        }
        return subArrs;
    }
}
