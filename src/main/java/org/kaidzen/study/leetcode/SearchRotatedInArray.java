package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.List;

public class SearchRotatedInArray {

    public int search1(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int length = nums.length;
        if (length == 2) {
            return nums[0] == target ? 0 : (nums[1] == target ? 1 : -1);
        }
        int pivot = findPivotal(nums, 0, length - 1, target);
        if (pivot == -1) {
            return binarySearch(nums, 0, length - 1, target);
        }
        if (nums[pivot] == target) {
            return pivot;
        }
        if (nums[0] <= target) {
            return binarySearch(nums, 0, pivot - 1, target);
        }
        return binarySearch(nums, pivot + 1, length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (right < left) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        if (target > nums[mid]) {
            return binarySearch(nums, mid + 1, right, target);
        }
        return binarySearch(nums, left, mid - 1, target);
    }

    private int findPivotal(int[] nums, int left, int right, int target) {
        if (right < left)
            return -1;
        if (right == left)
            return left;

        int mid = (left + right) / 2;
        if (nums[left] == nums[mid]) {
            return mid;
        }
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (mid > left && nums[mid] < nums[left]) {
            return mid - 1;
        }
        if (nums[left] < nums[mid] && target < nums[mid]) {
            return findPivotal(nums, left, mid - 1, target);
        }
        return findPivotal(nums, mid + 1, right, target);
    }

    public int search2(int[] nums, int target) {
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = new int[]{1, 3};
        int[] nums3 = new int[]{3, 5, 1};
        List<int[]> list = Arrays.asList(nums1, nums2);

        SearchRotatedInArray search = new SearchRotatedInArray();
        System.out.println(search.search1(nums3, 3));
        System.out.println(search.search1(nums1, 5));
        System.out.println(search.search1(nums2, 0));
        System.out.println(search.search1(nums2, 3));
    }
}
