package org.kaidzen.study.leetcode.y2023_2024.array;

import java.util.Random;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        KthLargestElementInArray kthLargest =new KthLargestElementInArray();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(kthLargest.findKthLargest(nums, k));

        int[] nums2 = new int[]{3,2,3,1,2,4,5,5,6};
        int k2 = 4;
        System.out.println(kthLargest.findKthLargest(nums2, k2));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }

    private int quickSelect(int[] nums, int left, int right, int k){
        if(left == right) return nums[left];

        final Random random = new Random();
        int pivotInx = random.nextInt(right - left + 1) + left;
        int nextPivotInx = partition(nums, left, right, pivotInx);

        if (nextPivotInx == k) {
            return nums[k];
        } else if(nextPivotInx < k){
            return quickSelect(nums, nextPivotInx+1, right, k);
        }
        return quickSelect(nums, left, nextPivotInx-1, k);
    }

    private int partition(int[] nums, int left, int right, int pivotInx){
        int pivot = nums[pivotInx];
        swap(nums, pivotInx, right);
        pivotInx = left;

        for (int i=left; i<=right; i++){
            if(nums[i] <= pivot){
                swap(nums, i, pivotInx++);
            }
        }
        return pivotInx-1;
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
