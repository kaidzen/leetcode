package org.kaidzen.study.leetcode.july2022;

import org.kaidzen.study.leetcode.util.ResourceFile;

import java.util.Arrays;

public class NumberOfWaysToSplitArray {

    public static void main(String[] args) {
        NumberOfWaysToSplitArray ways = new NumberOfWaysToSplitArray();

        int[] nums = new int[]{10, 4, -8, 7};
        System.out.println("Amount: " + ways.waysToSplitArray(nums));

        int[] nums2 = new int[]{2, 3, 1, 0};
        System.out.println("Amount: " + ways.waysToSplitArray(nums2));

        int[] nums3 = ways.array();
        System.out.println("Amount: " + ways.waysToSplitArray(nums3));
        System.out.println("Amount2: " + ways.waysToSplitArray2(nums3));
    }

    public int waysToSplitArray(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        int count = 0;
        int leftSum = 0;
        int rightSum = sum;
        for (int i = 0; i < length-1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum >= rightSum) {
                count++;
            }
        }
        return count;
    }

    public int waysToSplitArray2(int[] nums) {
        final int n = nums.length;
        long sum = 0;
        for (int i=0; i<n; i++) {
            sum += nums[i];
        }
        int count = 0;
        long left = 0;
        for (int i=0; i<n-1; i++) {
            left += nums[i];
            final long right = (sum - left);
            if (left >= right) count++;
        }
        return count;
    }

    private int[] array() {
        String fileName = "largeIntArray.txt";

        return ResourceFile.listFromFile(fileName).stream()
                .flatMap(str -> Arrays.stream(str.split(",")))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
