package org.kaidzen.study.leetcode.y2025.arrays;

/**
 * The solution is pretty intuitive. We keep expanding the window by moving the right pointer.
 * When the window has reached the limit of 0's allowed, we contract (if possible) and save
 * the longest window till now. The answer is the longest desirable window.
 *
 * Algorithm
 * Initialize two pointers. The two pointers help us to mark the left and right end of the window/subarray
 * with contiguous 1's. Also initialize curr to keep track of how many zeroes are in the window.
 *
 * left = 0, right = 0, curr = 0
 *
 * We use the right pointer to expand the window until the window/subarray is desirable. i.e. number
 * of 0's in the window are in the allowed range of [0, k].
 * Once we have a window which has more than the allowed number of 0's,
 * we can move the left pointer ahead until the window is valid again.
 */
public class MaxConsecutiveOnesIII_1004 {

    /**
     * T = O(n), S = O(1)
     */
    public int longestOnes(int[] nums, int k) {
        int cur = 0;
        int l = 0;
        int ans = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                cur++;
            }
            while (cur > k) {
                if (nums[l] == 0) {
                    cur--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
