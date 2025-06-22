package org.kaidzen.study.leetcode.y2025.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray_189 {

    public static void main(String[] args) {
        RotateArray_189 ra = new RotateArray_189();

        int[] array = new int[] {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(array));

        ra.rotate(array, 3); //[5,6,7,1,2,3,4]
        System.out.println(Arrays.toString(array));

    }


    /**
     * First we reverse input.
     * Steps used as pivotal index for input array.
     * Then 2 arrays, separated by pivotal index, rotated independently
     * T = O(n)
     * S = O(1)
     * @param nums input array
     * @param k steps to rotate input array
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        // remove "excess" loops in steps
        k = k % length;
        int l = 0;
        int r = length - 1;
        // reverse entire array
        reverse(nums, l, r);
        //now we will split it by k and reverse those parts
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        if (left > right) return;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

}
