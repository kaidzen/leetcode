package org.kaidzen.study.leetcode.june2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset3(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        if (nums != null && nums.length != 0) {
            int length = nums.length;
            Arrays.sort(nums);
            int[] dp = new int[length];
            Arrays.fill(dp, 1);
            int[] parent = new int[length];
            Arrays.fill(parent, -1);

            int max = 0;
            int maxIndex = -1;

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
                if (dp[i] > max) {
                    maxIndex = i;
                    max = dp[i];
                }
            }
            while (maxIndex != -1) {
                subset.add(nums[maxIndex]);
                maxIndex = parent[maxIndex];
            }
        }
        return subset;
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        Arrays.sort(nums);
        int[] nextIdx = new int[n];
        Arrays.fill(nextIdx, -1);
        int[] sizes = new int[n];
        Arrays.fill(sizes, 1);
        int maxLen = 1;
        int maxIdx = 0;
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            int max = 0;
            int maxInIdx = i;
            while (j < n) {
                if (nums[j] % nums[i] == 0 && sizes[i] > max) {
                    max = sizes[j];
                    maxInIdx = j;
                }
                j++;
            }
            if (maxInIdx != i) {
                sizes[i] += sizes[maxInIdx];
                nextIdx[i] = maxInIdx;
                if (max + 1 > maxLen) {
                    maxLen = max + 1;
                    maxIdx = i;
                }
            }
        }
        int current = maxIdx;
        while (current >= 0) {
            result.add(nums[current]);
            current = nextIdx[current];
        }
        return result;
    }

    public List<Integer> largestDivisibleSubset1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return result;
        }
        Arrays.sort(nums);
        return result;
    }

    public static void main(String[] args) {
//        Input: [1,2,3]
//        Si % Sj = 0 or Sj % Si = 0.
//        Output: [1,2] (of course, [1,3] will also be ok)
    }
}
