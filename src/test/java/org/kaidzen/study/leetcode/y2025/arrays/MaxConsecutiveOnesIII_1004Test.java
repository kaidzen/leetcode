package org.kaidzen.study.leetcode.y2025.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConsecutiveOnesIII_1004Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(6, new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void validate(int answer, int[] nums, int k) {
        final int result = new MaxConsecutiveOnesIII_1004().longestOnes(nums, k);

        assertEquals(answer, result);
    }
}