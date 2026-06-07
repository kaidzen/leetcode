package org.kaidzen.study.leetcode.y2025.hashtables;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestUniqueNumber_1133Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(8, new int[]{5,7,3,9,4,9,8,3,1})
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void verify(int answer, int[] nums) {
        int result = new LargestUniqueNumber_1133().largestUniqueNumber(nums);
        assertEquals(answer, result);
    }
}