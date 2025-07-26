package org.kaidzen.study.leetcode.y2025.hashtables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Find longest consecutive subsequence.
 * Time complexity MUST be O(n)
 * Set used to skip duplicates and ability of fast search.
 * To resolve TimeLimitExceeded, final step done with elements in the set.
 */
public class LongestConsecutiveSequence_128 {

    public static void main(String[] args) {
        LongestConsecutiveSequence_128 finder = new LongestConsecutiveSequence_128();

        int[] nums = new int[] {100,4,200,1,3,2};
        System.out.println(finder.longestConsecutive(nums)); // 4

        String fileName = "longestConsecutiveSequence_128.txt";

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final List<String> integers;

        try (final InputStream stream = loader.getResourceAsStream(fileName)) {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

            integers = bufferedReader.lines()
                    .map(line -> line.split(","))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        nums = new int[integers.size()];
        System.out.println("size: " + nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(integers.get(i));
        }
        long start = System.currentTimeMillis();
        System.out.println(finder.longestConsecutive(nums)); // 4
        long end = System.currentTimeMillis();
        System.out.println("Duration: " + (end - start));

    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n: nums) {
            set.add(n);
        }
        int max = 1;
        for (int n: set) {
            if (!set.contains(n-1)) {
                int cur = 0;
                while (set.contains(n + cur)) {
                    cur++;
                }
                max = Math.max(cur, max);
            }
        }
        return max;
    }
}
