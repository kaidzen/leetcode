package org.kaidzen.study.leetcode.y2025.stackNqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AsteroidsCollision_735Test {

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(new int[]{5, 10, -5}, new int[]{5, 10}),
                Arguments.of(new int[]{3,5,-6,2,-1,4}, new int[]{-6,2,4}),
                Arguments.of(new int[]{5, 10, -5}, new int[]{5, 10})
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void verify(int[] input, int[] answ) {
        final int[] result = new AsteroidsCollision_735().asteroidCollision(input);

        Assertions.assertArrayEquals(answ, result);
    }
}