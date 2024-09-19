package org.kaidzen.study.leetcode.y2023_2024.two_pointers;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();

        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(sum.threeSum(nums));
        System.out.println(sum.threeSum2(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        final int length = nums.length;
        List<List<Integer>> result = new ArrayList<>(length);
        Arrays.sort(nums);

        for(int a = 0; a< length; a++){
            if (a>0 && nums[a] == nums[a-1]){
                continue;
            }
            int l = a+1;
            int r = length-1;
            while (l < r){ //as they should be uniq
                int treeSum = a + nums[l] + nums[r];
                if (treeSum > 0){
                    r--;
                } else if (treeSum < 0){
                    l++;
                } else {
                    result.add(Arrays.asList(a, nums[l], nums[r]));
                    l++;
                    while (nums[l] == nums[l-1] && l<r){
                        l++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);

        final int length = nums.length;
        for(int a = 0; a <= length - 3 && nums[a] <= 0;){
            int left = a + 1, right = length - 1;
            if (0 - nums[a] - nums[left] < 0) break;

            while (left < right) {
                int sum = nums[a] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--; //skip duplicated number
                } else {
                    if (sum == 0) {
                        resultSet.add(Arrays.asList(nums[a], nums[left], nums[right--]));
                        while (left < right && nums[right] == nums[right + 1]) right--; //skip duplicated number
                    }
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++; //skip duplicated number
                }
            }
            a++;
            while(a < length - 2 && nums[a] == nums[a - 1]) a++; //skip duplicated number
        }
        return new ArrayList<>(resultSet);
    }
}
