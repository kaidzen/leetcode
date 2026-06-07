package org.kaidzen.study.leetcode.y2025.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfWaysToSplitArray_2270Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(3, new int[]{100000,-100000,100000,-100000})
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void validate(int answer, int[] nums) {
        final int result = new NumberOfWaysToSplitArray_2270().waysToSplitArray(nums);

        assertEquals(answer, result);
    }
}