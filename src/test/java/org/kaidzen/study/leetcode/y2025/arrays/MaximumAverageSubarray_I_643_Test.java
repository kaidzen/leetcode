package org.kaidzen.study.leetcode.y2025.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAverageSubarray_I_643_Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(12.75000, new int[]{1,12,-5,-6,50,3}, 4),
                Arguments.of(2.8, new int[]{4,0,4,3,3}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void validate(double result, int[] nums, int k) {
        final double average = new MaximumAverageSubarray_I_643().findMaxAverage(nums, k);

        assertEquals(result, average);
    }
}