package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SmallerThenCurrent {

    public static void main(String[] args) {
        SmallerThenCurrent finder = new SmallerThenCurrent();

//        Input: nums = [8,1,2,2,3]
//        Output: [4,0,1,1,3]
        int[] nums1 = new int[]{8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(finder.smallerNumbersThanCurrent(nums1)));

//        Input: nums = [6,5,4,8]
//        Output: [2,1,0,3]
        int[] nums2 = new int[]{6, 5, 4, 8};
        System.out.println(Arrays.toString(finder.smallerNumbersThanCurrent(nums2)));

//        Input: nums = [7,7,7,7]
//        Output: [0,0,0,0]
        int[] nums3 = new int[]{7, 7, 7, 7};
        System.out.println(Arrays.toString(finder.smallerNumbersThanCurrent(nums3)));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {

        List<Integer> sorted = Arrays.stream(nums)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        SortedMap<Integer, Integer> map = new TreeMap<>(); // store for "smaller than" amounts
        int previous = Integer.MIN_VALUE;
        AtomicInteger counter = new AtomicInteger(0);

        for (int val : sorted) {
            if (val > previous) {
                map.putIfAbsent(val, counter.getAndIncrement()); // as we process sorted, just increment
            }
        }

        final int length = nums.length;
        int[] rates = new int[length];
        for (int i = 0; i < length; i++) {
            rates[i] = map.get(nums[i]); // prepare result
        }

        return rates;
    }
}
