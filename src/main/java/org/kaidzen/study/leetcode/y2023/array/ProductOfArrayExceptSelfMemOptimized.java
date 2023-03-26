package org.kaidzen.study.leetcode.y2023.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelfMemOptimized {

    public static void main(String[] args) {
        ProductOfArrayExceptSelfMemOptimized product = new ProductOfArrayExceptSelfMemOptimized();

        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(product.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int prefix = 1;
        for(int i=0; i<length; i++){
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i=length-1; i>=0; i--){
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }
}
