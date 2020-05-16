package org.kaidzen.study.leetcode;

public class MaximumSumOfCircularSubarray {

    public int maxSubarraySumCircular(int[] A) {
        int totalSum = 0;
        int maxEndingAt = 0;
        int minEndingAt = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for(int x: A){
            totalSum += x;
            maxEndingAt = Math.max(maxEndingAt + x, x);
            maxSum = Math.max(maxEndingAt, maxSum);
            minEndingAt = Math.min(minEndingAt + x, x);
            minSum = Math.min(minEndingAt, minSum);
        }
        if (maxSum > 0){
            return Math.max(maxSum, totalSum - minSum);
        }
        return maxSum;
    }

    //Kadance's algorithm
    public static void main(String[] args) {
        MaximumSumOfCircularSubarray circularSub = new MaximumSumOfCircularSubarray();

//        Input: [1,-2,3,-2]
//        Output: 3
//        Explanation: Subarray [3] has maximum sum 3
        System.out.println(circularSub.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
//        Input: [5,-3,5]
//        Output: 10
//        Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
        System.out.println(circularSub.maxSubarraySumCircular(new int[]{5,-3,5}));
//        Input: [3,-2,2,-3]
//        Output: 3
//        Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
        System.out.println(circularSub.maxSubarraySumCircular(new int[]{3,-2,2,-3}));

    }
}
