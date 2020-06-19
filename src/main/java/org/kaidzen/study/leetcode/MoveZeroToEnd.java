package org.kaidzen.study.leetcode;

public class MoveZeroToEnd {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        MoveZeroToEnd move = new MoveZeroToEnd();
        move.moveZeroes(arr);
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        while (count < length) {
            nums[count++] = 0;
        }
    }
}
