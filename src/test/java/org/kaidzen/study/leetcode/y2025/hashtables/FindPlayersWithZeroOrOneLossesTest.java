package org.kaidzen.study.leetcode.y2025.hashtables;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPlayersWithZeroOrOneLossesTest {

    public static Stream<Arguments> cases() {
        return Stream.of(
//                Arguments.of(List.of(List.of(1, 2, 10), List.of(4, 5, 7, 8)), new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}}),
                Arguments.of(List.of(List.of(1,2,3,4,6), List.of()), new int[][]{{1,5},{2,5},{2,8},{2,9},{3,8},{4,7},{4,9},{5,7},{6,8}})
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void verify(List<List<Integer>> answer, int[][] matches) {
        final List<List<Integer>> result = new FindPlayersWithZeroOrOneLosses().findWinners(matches);
        assertEquals(answer, result);
    }
}