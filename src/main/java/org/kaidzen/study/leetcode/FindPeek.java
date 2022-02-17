package org.kaidzen.study.leetcode;

public class FindPeek {

    /**
     * @param args
     */

    public static void main(String[] args) {
        FindPeek pick = new FindPeek();
//        Input: nums = [1,2,3,1]
//        Output: 2
        int peakElement = pick.findPeakElement(new int[]{1, 2, 3, 1});
        System.out.println(peakElement);

//        Input: arr = [0,10,5,2]
//        Output: 1
        int peakElementInMounting = pick.findPeakElement(new int[]{0, 10, 5, 2});
        System.out.println(peakElementInMounting);

//        Input: arr = [3,4,5,1]
//        Output: 2
        int peakElementInMounting2 = pick.findPeakElement(new int[]{3, 4, 5, 1});
        System.out.println(peakElementInMounting2);

//        Input: arr = [24,69,100,99,79,78,67,36,26,19]
//        Output: 2
        int peakElementInMounting3 = pick.findPeakElement(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19});
        System.out.println(peakElementInMounting3);

    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
