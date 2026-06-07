package org.kaidzen.study.leetcode.y2025.hashtables;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountNumberOfNiceSubarrays_1248Test {

    public static Stream<Arguments> causes() {
        return Stream.of(
                Arguments.of(2, new int[]{1,1,2,1,1}, 3),
                Arguments.of(0, new int[]{2,4,6}, 1),
                Arguments.of(16, new int[]{2,2,2,1,2,2,1,2,2,2}, 2)
        );
    }

    public static Stream<Arguments> causes2() {
        return Stream.of(
                Arguments.of(8, new int[]{4,1,2,3,7,9,1,2,8}, 2)
        );
    }


    @ParameterizedTest
    @MethodSource("causes")
    public void verify(int answer, int[] nums, int k) {
        int result = new CountNumberOfNiceSubarrays_1248().numberOfSubarrays(nums, k);
        assertEquals(answer, result);
    }

    @ParameterizedTest
    @MethodSource("causes2")
    public void verify2(int answer, int[] nums, int k) {
        int result = new CountNumberOfNiceSubarrays_1248().numberOfSubarrays2(nums, k);
        assertEquals(answer, result);
    }

    @ParameterizedTest
    @MethodSource("causes2")
    public void verify3(int answer, int[] nums, int k) {
        int result = new CountNumberOfNiceSubarrays_1248().numberOfSubarrays3(nums, k);
        assertEquals(answer, result);
    }
}