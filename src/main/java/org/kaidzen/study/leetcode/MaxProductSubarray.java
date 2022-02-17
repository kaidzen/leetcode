package org.kaidzen.study.leetcode;

public class MaxProductSubarray {

    public static void main(String[] args) {
        MaxProductSubarray product = new MaxProductSubarray();
        int[] array1 = {2, 3, -2, 4};
        int[] array2 = {-2, 3, -4};
        System.out.println(product.maxProduct(array1));
        System.out.println(product.maxProduct2(array1));

        System.out.println(product.maxProduct(array2));
        System.out.println(product.maxProduct2(array2));
    }

    private int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int currentMax = nums[0];
        int currentMin = nums[0];
        int finalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = currentMax;
            int num = nums[i];
            currentMax = Math.max(Math.max(currentMax * num, currentMin * num), num);
            currentMin = Math.min(Math.min(tempMax * num, currentMin * num), num);
            if (currentMax > finalMax) {
                finalMax = currentMax;
            }
        }
        return finalMax;
    }

    //not correct
    private int maxProduct2(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int currentMax = nums[0];
        int finalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], nums[i] * currentMax);
            finalMax = Math.max(currentMax, finalMax);
        }
        return finalMax;
    }
}
