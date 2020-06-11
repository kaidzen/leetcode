package org.kaidzen.study.leetcode.june2020;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        /*
        * Here common binary search extended ("<" -> "<="), as we should find target, that can be
        * out of border of left and right (when some num is missed in sequence)
         */
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] < target){
                //extended to cover "missed index"
                left = mid + 1;
            } else if (nums[mid] > target){
                //Also extended to cover "missed index"
                right = mid - 1;
            } else {
                return mid;
            }
        }
        //Here we return index of "missed" insert position
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchPosition = new SearchInsertPosition();
//      Input: [1,3,5,6], 5
//      Output: 2
        System.out.println(searchPosition.searchInsert(new int[]{1,3,5,6,}, 5));
//        Input: [1,3,5,6], 7
//        Output: 4
        System.out.println(searchPosition.searchInsert(new int[]{1,3,5,6,}, 7));
    }
}
