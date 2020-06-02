package org.kaidzen.leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int length = nums.length;

        int[] productBottom = new int[length];
        for (int i = 0; i < length; ++i) {
            productBottom[i] = temp;
            temp *= nums[i];
        }

        int[] productTop = new int[length];
        temp = 1;
        for (int i = length-1; i >= 0; --i) {
            productTop[i] = temp;
            temp *= nums[i];
        }

        int[] product = new int[length];
        for (int i = 0; i < length; ++i) {
            product[i] = productBottom[i] * productTop[i];
        }
        return product;
    }

    public static void main(String[] args) {
        int[]input =  {1,2,3,4};
        int[] output = {24,12,8,6};
        ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();

        System.out.println(Arrays.toString(product.productExceptSelf(input)));
    }
}
