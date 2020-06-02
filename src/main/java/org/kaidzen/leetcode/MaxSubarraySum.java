package org.kaidzen.leetcode;

public class MaxSubarraySum {

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubarraySum sub = new MaxSubarraySum();
        System.out.println(sub.maxSubArray(array));
    }

    public int maxSubArray(int[] nums) {
        int maxGlobal = nums[0];
        int maxCurrent = nums[0];
        int start = 1;
        if (nums.length == start){
            return maxGlobal;
        } else if (nums.length == 2){
            return Math.max(maxGlobal, getMax(nums, maxCurrent, start));
        }
        for (int i = start; i < nums.length; i++) {
            maxCurrent = getMax(nums, maxCurrent, i);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
            }
        return maxGlobal;
    }

    private int getMax(int[] nums, int current, int i) {
        return Math.max(nums[i], current + nums[i]);
    }

}
