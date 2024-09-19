package org.kaidzen.study.leetcode.y2023_2024.array;

public class MedianOfSortedArrays {

    public static void main(String[] args) {
        MedianOfSortedArrays median = new MedianOfSortedArrays();
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{2};
        //Should be O(log(m+n))
        System.out.println(median.findMedianSortedArrays(nums1, nums2));



    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int n = l1 + l2;
        int[] arr = new int[n];
         int i=0, j=0, k=0;
        while (i<=l1 && j <=l2){
            if (i == l1){
                while (j < l2) arr[k++] = nums2[j++];
                break;
            } else if (j == l2){
                while (i < l1) arr[k++] = nums1[i++];
                break;
            }
            if (nums1[i] < nums2[j]){
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        if (n % 2 == 0) {
            return (float)(arr[n/2 - 1] + arr[n/2]) / 2;
        } else {
            return arr[n/2];
        }
    }
}
