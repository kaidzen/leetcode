package org.kaidzen.study.leetcode.july2022;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NumberOfWaysToSplitArray {

    public static void main(String[] args) {
        NumberOfWaysToSplitArray ways = new NumberOfWaysToSplitArray();

        int[] nums = new int[]{10, 4, -8, 7};
        System.out.println("Amount: " + ways.waysToSplitArray(nums));

        int[] nums2 = new int[]{2, 3, 1, 0};
        System.out.println("Amount: " + ways.waysToSplitArray(nums2));

        int[] nums3 = ways.array();
        System.out.println("Amount: " + ways.waysToSplitArray(nums3));
    }

    public int waysToSplitArray(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        int count = 0;
        int leftSum = 0;
        int rightSum = sum;
        for (int i = 0; i < length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum >= rightSum) {
                count++;
            }
        }
        return count;
    }

    private int[] array() {
        String fileName = "largeIntArray.txt";

        try {
            final URI resource = Thread.currentThread().getContextClassLoader().getResource(fileName).toURI();
            final List<String> strings = Files.readAllLines(Paths.get(resource), StandardCharsets.UTF_8);
            final Stream<String> stringStream = strings.stream()
                    .flatMap(str -> Arrays.stream(str.split(",")))
//                    .mapToInt(value -> Integer.parseInt(value))
                    ;
            return stringStream
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new int[]{};
    }
}
