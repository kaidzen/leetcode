package org.kaidzen.study.leetcode.y2025.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductOfArrayExceptSelf_238 {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf_238 prExcept = new ProductOfArrayExceptSelf_238();

        int[] array = new int[] {1,2,3,4};
        System.out.println(Arrays.toString(prExcept.product(array))); //[24,12,8,6]
    }

    /**
     * Looks like dynamic programming approach? We will calculate "prefix sum" before each number (by index in input array)
     * Then we go in reverse direction and calculate "postfix sum" after each number (by index in input array)
     * Result array will be used as storage for those manipulations.
     * T =O(n)
     * S = O(1) * by trick with usage of result array as store for computations.
     * @param nums input array
     * @return result array with products, except value by this index from source.
     */
    public int[] product(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
           res[i] *= postfix;
           postfix *= nums[i];
        }

        return res;
    }
}
