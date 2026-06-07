package org.kaidzen.study.leetcode.y2025.stackNqueue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovingAverageFromDataStream_346Test {

    public static Stream<Arguments> cause() {
        return Stream.of(
                Arguments.of(new double[]{1.0, 5.5, 4.666666666666667, 6.0}, new int[]{1, 10, 3, 5}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("cause")
    void verify(double[] answer, int[] vals, int size) {
        final MovingAverageFromDataStream_346 moveAvg = new MovingAverageFromDataStream_346(size);
        double[] results = new double[vals.length];
        for (int i = 0; i < vals.length; i++) {
            results[i] = moveAvg.next(vals[i]);
        }

        assertArrayEquals(answer, results);
    }

    @ParameterizedTest
    @MethodSource("cause")
    void verify2(double[] answer, int[] vals, int size) {
        final MovingAverageFromDataStream_346 moveAvg = new MovingAverageFromDataStream_346(size);
        double[] results = new double[vals.length];
        for (int i = 0; i < vals.length; i++) {
            results[i] = moveAvg.next2(vals[i]);
        }

        assertArrayEquals(answer, results);
    }
}