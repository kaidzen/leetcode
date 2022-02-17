package org.kaidzen.study.leetcode;

public class FindNonPair {

    public int findSingle(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) {
                    right = mid - 2;
                } else if (nums[mid] == nums[mid + 1]) {
                    left = mid + 2;
                } else {
                    return nums[mid];
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else if (nums[mid] == nums[mid + 1]) {
                    right = mid - 1;
                }
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {
        FindNonPair nonPair = new FindNonPair();
        //Input: int[] array = new int[]{1,1,2,3,3,4,4,8,8};
        //Output: 2
        int[] array3 = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(nonPair.findSingle(array3));
        //Input: int[] array = new int[]{1,1,2,3,3,4,4,5,5};
        //Output: 2
        int[] array = new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(nonPair.findSingle(array));
        //Input: int[] array = new int[]{1,1,2,2,3,3,4,4,5,5,6,7,7};
        //Output: 2
        int[] array2 = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7};
        System.out.println(nonPair.findSingle(array2));
    }
}
