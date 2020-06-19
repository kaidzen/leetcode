package org.kaidzen.study.leetcode;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1;}

        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int start = left;
        left = 0;
        right = nums.length - 1;

        if (target >= nums[start] && target <= nums[right]){
            left = start;
        } else {
            right = start;
        }

        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1;}

        int low = 0;
        int high = nums.length - 1;
        int first = nums[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = nums[mid];
            if (value == target) {
                return mid;
            }
            boolean isBigger = value > target;
            boolean isTargetBig = target >= first;
            if (isBigger == isTargetBig) {
                if (value < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (isBigger) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private int findPivot(int[] nums) {
        return 0;
    }

    public int binarySearch(int[] arr, int fromIndex, int toIndex, int key) {
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 5, 6, 7, 0, 1, 2};

        SearchInRotatedSortedArray searcher = new SearchInRotatedSortedArray();

        System.out.println(searcher.search(arr1, 3));
    }
}
