package org.kaidzen.study.leetcode.y2025.stackNqueue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MakeTheStringGreat_1544Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("", "abBAcC"),
                Arguments.of("leetcode", "leEeetcode")
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void verify(String answer, String input) {
        final String result = new MakeTheStringGreat_1544().makeGood(input);

        assertEquals(answer, result);
    }

    @ParameterizedTest
    @MethodSource("cases")
    void verify2(String answer, String input) {
        final String result = new MakeTheStringGreat_1544().makeGood2(input);

        assertEquals(answer, result);
    }
}