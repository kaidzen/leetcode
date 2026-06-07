package org.kaidzen.study.leetcode.y2025.monotonicstack;

import java.util.*;

/**
 * The next greater element of some element x in an array is the first greater element that is
 * to the right of x in the same array.
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next
 * greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 *
 * T = O(n + m)
 * S = O(n)
 */
public class NextGreaterElement_496 {

    public static void main(String[] args) {
        NextGreaterElement_496 find = new NextGreaterElement_496();

        int[] nums1 = new int[] {4,1,2};
        int[] nums2 = new int[] {1,3,4,2};
        System.out.println(Arrays.toString(find.nextGreaterElement(nums1, nums2))); // [-1, 3, -1]
    }

    /**
     * Monotonic stack approach. For each element in nums2 we check if there is greater value,
     * while it is stored in the stack
     * @param nums1
     * @param nums2
     * @return Array, that shows if next greater element for each one from nums1 exists n the nums2;
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            int cur = nums2[i];
            while (!stack.isEmpty() && cur > stack.peekLast()) {
                Integer val = stack.pollLast();
                Integer idx = map.get(val);
                res[idx] = cur;
            }
            if (map.containsKey(cur)) {
                stack.offer(cur);
            }
        }
        return res;
    }
}
