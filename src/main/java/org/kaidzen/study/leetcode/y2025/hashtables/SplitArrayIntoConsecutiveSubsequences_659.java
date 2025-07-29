package org.kaidzen.study.leetcode.y2025.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * Try to split array into consequence sub-sequences, with min length 3
 * We count all numbers, then trying to extend existing or create new subsequence
 * T = O(n)
 * S = O(n)
 */
public class SplitArrayIntoConsecutiveSubsequences_659 {

    public static void main(String[] args) {
        SplitArrayIntoConsecutiveSubsequences_659 sequences = new SplitArrayIntoConsecutiveSubsequences_659();

/*
        int[] nums = new int[] {1,2,3,3,4,5};
        System.out.println(sequences.isPossible(nums)); //true
*/

        int[] nums2 = new int[] {1,2,3,3,4,4,5,5};
        System.out.println(sequences.isPossible(nums2)); //false
    }

    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>(); // number to amount
        Map<Integer,Integer> ends = new HashMap<>(); // calculates last element in sequences

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (freq.getOrDefault(num, 0) > 0) {
                freq.put(num, freq.getOrDefault(num, 0) - 1);
                // if found previous element of sequence - replace it with current
                if(ends.getOrDefault(num - 1, 0) > 0) {
                    ends.put(num, ends.getOrDefault(num, 0) + 1);
                    ends.put(num - 1, ends.get(num - 1) - 1);
                  // if num is beginning of another sequence - add new sequence's ending
                } else if (freq.getOrDefault(num+1, 0) > 0 && freq.getOrDefault(num+2, 0) > 0) {
                    freq.put(num+1, freq.getOrDefault(num+1, 0) - 1);
                    freq.put(num+2, freq.getOrDefault(num+2, 0) - 1);
                    ends.put(num+2, ends.getOrDefault(num, 0) + 1);
                } else {
                    return false;
                }
            }

        }
        return true;
    }
}
