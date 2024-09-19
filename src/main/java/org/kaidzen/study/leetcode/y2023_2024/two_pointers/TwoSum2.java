package org.kaidzen.study.leetcode.y2023_2024.two_pointers;

import java.util.Arrays;

public class TwoSum2 {

    public static void main(String[] args) {

        TwoSum2 sum = new TwoSum2();

        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(sum.twoSum(numbers, target)));

        int[] numbers2 = new int[]{2,3,4};
        int target2 = 6;
        System.out.println(Arrays.toString(sum.twoSum(numbers2, target2)));

    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r){
            int currSum = numbers[l] + numbers[r];
            if (currSum > target){
                r--;
            } else if (currSum < target){
                l++;
            } else {
                //+1 - as we have '1-th' based array
                return new int[]{l+1, r+1};
            }
        }
        return new int[0];
    }
}
