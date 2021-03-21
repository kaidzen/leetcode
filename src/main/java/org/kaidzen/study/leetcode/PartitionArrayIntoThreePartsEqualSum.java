package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionArrayIntoThreePartsEqualSum {

    public static void main(String[] args) {
//        Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
//        Output: true
//        Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//
//        Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
//        Output: false
//
//        Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
//        Output: true
//        Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4

        List<int[]> list = Arrays.asList(
                new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1},
                new int[]{0,2,1,-6,6,7,9,-1,2,0,1},
                new int[]{3,3,6,5,-2,2,5,1,-9,4}
        );
        PartitionArrayIntoThreePartsEqualSum partition = new PartitionArrayIntoThreePartsEqualSum();

        list.forEach(arr -> System.out.println(partition.canThreePartsEqualSum(arr)));

    }

    public boolean canThreePartsEqualSum(int[] arr) {
        int length = arr.length;
        int[] sufSum = new int[length + 1];
        for (int i = length - 1; i >= 0; i--) {
            sufSum[i] = sufSum[i + 1] + arr[i];
        }
        Map<Integer, Integer> prefSum = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += arr[i];
            prefSum.putIfAbsent(sum, i);
        }
        for (int i = 2; i < length; i++) {
            int diff = sum - sufSum[i];
            if (diff == sufSum[i] && prefSum.containsKey(diff) && prefSum.get(diff) < i - 1) {
                return true;
            }
            sum += arr[i];
            prefSum.putIfAbsent(sum, i);
        }
        return false;
    }
}
