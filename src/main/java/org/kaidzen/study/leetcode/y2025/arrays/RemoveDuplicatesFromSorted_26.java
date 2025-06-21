package org.kaidzen.study.leetcode.y2025.arrays;

import java.util.*;

public class RemoveDuplicatesFromSorted_26 {

    public static void main(String[] args) {
        RemoveDuplicatesFromSorted_26 rd = new RemoveDuplicatesFromSorted_26();

        int[] arr = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.printf("%d, %s%n", rd.removeDuplicates(arr), Arrays.toString(arr)); //5, but fail with unmodified input array

        int[] arr1 = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.printf("%d, %s%n", rd.removeDuplicates2(arr1), Arrays.toString(arr1)); // 5, [0, 1, 2, 3, 4, 2, 2, 3, 3, 4]

        int[] arr2 = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.printf("%d, %s%n", rd.removeDuplicates3(arr2), Arrays.toString(arr2)); // 5, [0, 1, 2, 3, 4, 2, 2, 3, 3, 4]

    }

    /**
     * Naive approach. Sort in additional list, placing from different sides.
     * @param nums input, must be modified after processing
     * @return amount of unique elements.
     */
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int l = 0;
        int r = l + 1;
        if (nums.length == 1) return -1;

        while (r < nums.length) {
            if (!set.contains(nums[r])) {
                list.add(nums[r]);
                set.add(nums[r]);
            }
            r++;
            l++;
        }
        return set.size();
    }

    /**
     * 2 pointer approach. Left is as index on input array, right one - as pointer, that is used for look up for
     * the next appropriate
     * @param nums input, must be modified after processing
     * @return amount of unique elements.
     */
    public int removeDuplicates2(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public int removeDuplicates3(int[] nums) {
        int l = 0;
        for (int r = 0, n = nums.length; r < n; r++) {
            if (nums[l] != nums[r]) {
                l++;
                nums[l] = nums[r];
            }
        }
        return l + 1;
    }
}
