package org.kaidzen.study.leetcode.y2025.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumValueToGetPositiveStepByStepSum_1413 {

    /**
     * 1. Set left = 1 and right = m * n + 1, where n is the number of elements in nums and m is the absolute value
     * that an element could be. If the minimum possible value of an element is unknown, the minimum value in the array
     * nums can be used instead.
     * 2. Get middle value from left and right, which is middle = (left + right) / 2.
     * 3. Iterate over the array nums with total = middle as the initial total. Each step, increment total by
     * the current number in nums.
     * 4. If we complete the iteration and at every step-by-step total was greater than or equal to 1,
     * then total is valid, so let right = middle. Otherwise, let left = middle + 1.
     * 5. Repeat the steps 2, 3, and 4 until the two boundaries overlap, i.e., left == right, which means that we
     * have found the minimum valid startValue that ensures every step-by-step total is greater than or equal to 1.
     * We can return either left or right as the answer.
     */
    public int minStartValue(int[] nums) {
        final int len = nums.length;
        int m = 100;
        int l = 1;
        int r = len * m + 1;
        Map<Integer, Integer> map = new HashMap<>();

        final List<Integer> list = map.entrySet().stream()
                .filter(ent -> ent.getValue() == len)
                .map(Map.Entry::getKey)
                .toList();

        while (l < r) {
            int mid = (l + r) / 2;
            int total = mid;
            boolean isValid = true;
            for (int num : nums) {
                total += num;
                if (total < 1) {
                    isValid = false;
                }
            }
            if (isValid) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return l;
    }
}
