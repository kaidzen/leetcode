package org.kaidzen.study.leetcode.y2025.arrays;

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10-5 will be accepted.
 *
 * Example 1:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 *
 *  Example 2:
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 * Constraints:
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */
public class MaximumAverageSubarray_I_643 {

    /**
     * Cumulative sum approach
     * Construct helper  with cumulative sum, that take nums space in additional
     * T = O(n), S = O(n)
     */
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        long[] sum = new long[len];

        sum[0] = nums[0];
        for (int i=1; i < len; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        double res = (sum[k-1] * 1.0) / k;

        for (int i=k; i < len; i++) {
            long subArrSum = sum[i] - sum[i - k];
            double avg = (subArrSum * 1.0) / k;
            res = Math.max(avg, res);
        }
        return res;
    }

    /**
     * Sliding window approach. Calculate initial windowSum, then shift it and find the maximum
     * of numeric value of the sliding window.
     * @param nums input
     * @param k constrain for the window size
     * @return max of numeric value for sliding window constrain divided by @param k
     */
    public double findMaxAverage2(int[] nums, int k) {
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        double res = windowSum;
        for (int i = k; i < nums.length; i++) {
            // Now, to determine the sum of elements from the index i+1 to the index i+k+1, all we need to do
            // is to subtract the element nums[i] from x and to add the element nums[i+k+1] to x
            windowSum += nums[i] - nums[i - k];
            res = Math.max(res, windowSum);
        }
        return res / k;
    }
}
