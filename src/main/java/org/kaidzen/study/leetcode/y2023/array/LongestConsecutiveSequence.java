package org.kaidzen.study.leetcode.y2023.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence checkSequence = new LongestConsecutiveSequence();

        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(checkSequence.longestSequence(nums));

        int[] nums2 = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(checkSequence.longestSequence(nums2));

    }

    public int longestSequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        Set<Integer> set = new HashSet<>(list);
        int longest = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) { //check if number has no left neighbor: so it's starts the sub-sequence
                int seqLength = 0;
                while (set.contains(num + seqLength)) { //iterating over sub-sequence and calculate it length
                    seqLength++;
                }
                longest = Math.max(longest, seqLength);
            }
        }
        return longest;
    }
}
