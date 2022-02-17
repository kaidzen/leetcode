package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.List;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int lastGoodPosition = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastGoodPosition) {
                lastGoodPosition = i;
            }
        }
        return lastGoodPosition == 0;
    }

    private boolean nonFaulty(int[] nums, int position) {
        return nums == null || position < nums.length - 1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 1, 4};
        int[] arr2 = new int[]{3, 2, 1, 0, 4};

        JumpGame game = new JumpGame();

        List<int[]> list = Arrays.asList(arr1, arr2);

        list.forEach(ints -> System.out.println(game.canJump(ints)));
    }
}
