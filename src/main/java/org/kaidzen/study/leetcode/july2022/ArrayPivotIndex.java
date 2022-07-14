package org.kaidzen.study.leetcode.july2022;

import java.util.Arrays;

public class ArrayPivotIndex {

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        ArrayPivotIndex pv = new ArrayPivotIndex();
        System.out.println("Pivot is: " + pv.pivotIndex(nums));
        System.out.println("Pivot is: " + pv.pivotIndex2(nums));
    }

    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int[] prefixSum = new int[length];
        for(int i=0; i<length; i++){
            if(i <= 1){
                prefixSum[i] = 0;
                continue;
            }
            calculateSums(prefixSum, nums, i);
        }

        System.out.println(Arrays.toString(prefixSum));
        for(int i=0; i<length; i++){
            final int current = prefixSum[length - 1] - prefixSum[i] - nums[i];
            if(prefixSum[i] == current){
                return i;
            }
        }
        return -1;
    }

    private void calculateSums(int[] prefixSum, int[] nums, int idx){
        int sum = 0;
        for  (int i=0; i<idx; i++){
            sum += nums[i];
        }
        prefixSum[idx] = sum;
    }

    public int pivotIndex2(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum = sum + num;
        }
        // now let's keep track of right sum and left sum
        int right_sum = sum;
        int left_sum = 0;

        for(int i=0;i<nums.length;i++)
        {
            right_sum = right_sum - nums[i];

            if(right_sum == left_sum)
            {
                return i;
            }

            left_sum = left_sum + nums[i];
        }

        return -1;
    }
}
