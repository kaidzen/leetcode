package org.kaidzen.study.leetcode.june2020;

public class H_Index2 {

    public int hIndex2(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int idx = n - 1;
        while (idx >= 0) {
            if (citations[idx] < n - idx) {
                break;
            }
            idx--;
        }
        return n - idx - 1;
    }

    public static void main(String[] args) {
//        Input: citations = [0,1,3,5,6]
//        Output: 3

        H_Index2 hIndexCounter = new H_Index2();
        System.out.println(hIndexCounter.hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(hIndexCounter.hIndex2(new int[]{0, 1, 3, 5, 6}));
    }
}
