package org.kaidzen.study.leetcode.y2025.hashtables;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Counting of zero-filled areas. Used 2 counter. One is general and one is for "internal" sub-arrays.
 * With each internal sub-array internal counter re-initialized every time and
 * final result flushed to general counter
 * T = O(n)
 * S = O(n)
 *
 */
public class NumberOfZeroFilledSubarrays_2348 {

    public static void main(String[] args) {
        String filename = "numbersOfZeroFilledSAubarrays.txt";
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final List<Integer> integers;
        try(InputStream stream = loader.getResourceAsStream(filename)) {
            integers = new BufferedReader(new InputStreamReader(stream)).lines()
                    .map(line -> line.split(","))
                    .flatMap(Arrays::stream)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] nums = new int[integers.size()];
        IntStream.range(0, nums.length).boxed()
                .forEach(i -> nums[i] = integers.get(i));

        NumberOfZeroFilledSubarrays_2348 counter = new NumberOfZeroFilledSubarrays_2348();

        System.out.println(counter.zeroFilledSubarray(nums));

    }

    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            } else {
                count = 0;
            }
            res += count;
        }
        return res;
    }


}
