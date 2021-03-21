package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.List;

public class NumberOfGoodPairs {

    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        List<int[]> list = Arrays.asList(
                new int[]{1, 2, 3, 1, 1, 3},
                new int[]{1, 1, 1, 1},
                new int[]{1,2,3}
        );
        NumberOfGoodPairs pairs = new NumberOfGoodPairs();
        list.forEach(
                arr -> System.out.println(pairs.numIdenticalPairs1(arr))
        );
        list.forEach(
                arr -> System.out.println(pairs.numIdenticalPairs2(arr))
        );
    }

    public int numIdenticalPairs1(int[] nums) {
        int pairs = 0;
        for (int i = 0; i < nums.length-1; i++) {
            final int current = nums[i];
            final int next = nums[i + 1];
            if (current == next) {
                pairs++;
            }
            int backCount = i+1;
            int temp = i;
            while (backCount > 0){
                if (temp > 0 && nums[--temp] == next){
                    pairs++;
                }
                backCount--;
            }

        }
        return pairs;
    }

    public int numIdenticalPairs2(int[] nums) {
        int count = 0;
        int[] similar = new int[MAX_VALUE];
        for (int num: nums) {
            count += similar[num]++;
        }
        return count;
    }
}
