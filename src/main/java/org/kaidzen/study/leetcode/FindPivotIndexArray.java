package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.List;

public class FindPivotIndexArray {

    public static void main(String[] args) {
        final List<Integer> objects = Arrays.asList(1, 2, 3);
        int[] arr1 = new int[]{1, 7, 3, 6, 5, 6};
        FindPivotIndexArray pivot = new FindPivotIndexArray();
        System.out.println(pivot.pivotIndex(arr1));
        System.out.println(pivot.pivotIndex2(objects));
    }

    private int pivotIndex2(List<Integer> arr) {
        int sum = 0, left = 0;
        for (int n : arr) sum += n;
        for (int i = 0; i < arr.size(); i++) {
            if (left == sum - left - arr.get(i)) {
                return i;
            }
            left += arr.get(i);
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for (int n : nums) sum += n;
        for (int i = 0; i < nums.length; i++) {
            if (left == sum - left - nums[i]) return i;
            left += nums[i];
        }
        return -1;
    }
}
