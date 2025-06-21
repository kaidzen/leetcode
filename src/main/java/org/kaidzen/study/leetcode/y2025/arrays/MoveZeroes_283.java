package org.kaidzen.study.leetcode.y2025.arrays;

import java.util.Arrays;

public class MoveZeroes_283 {

    public static void main(String[] args) {
        MoveZeroes_283 mz = new MoveZeroes_283();

        int[] arr = new int[]{0,1,0,3,12};
        mz.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 2 pointers approach. left as index of the latest non-zero element, right - as "zero finder"
     * T = O(n)
     * S = O(1)
     * @param nums input array, that should be modified in place
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int l = 0;
        int r = 0;
        while (r < length) {
            if (nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
            r++;
        }

    }
}
