package org.kaidzen.study.leetcode.y2025.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumValueToGetPositiveStepByStepSum1413Test {

    @ParameterizedTest
    @MethodSource("cases")
    public void validate(int answer, int[] nums) {
        final int result = new MinimumValueToGetPositiveStepByStepSum_1413().minStartValue(nums);

        assertEquals(answer, result);
    }

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(5, new int[]{-3,2,-3,4,2}),
                Arguments.of(1, new int[]{1,2}),
                Arguments.of(5, new int[]{1,-2,-3})
        );
    }
}