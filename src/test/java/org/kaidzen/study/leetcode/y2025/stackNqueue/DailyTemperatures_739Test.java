package org.kaidzen.study.leetcode.y2025.stackNqueue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DailyTemperatures_739Test {
    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, new int[]{73, 74, 75, 71, 69, 72, 76, 73}),
                Arguments.of(new int[]{1, 1, 1, 0}, new int[]{30, 40, 50, 60}),
                Arguments.of(new int[]{1, 1, 0}, new int[]{30, 60, 90})
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void verify(int[] answer, int[] temperatures) {
        final int[] result = new DailyTemperatures_739().dailyTemperatures(temperatures);

        assertArrayEquals(answer, result);
    }
}