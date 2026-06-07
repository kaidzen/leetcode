package org.kaidzen.study.leetcode.y2025.stackNqueue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimplifyPath_71Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("/home/user/Pictures", "/home/user/Documents/../Pictures")
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void verify(String answer, String inputPath) {
        final String result = new SimplifyPath_71().simplifyPath(inputPath);

        assertEquals(answer, result);
    }

    @ParameterizedTest
    @MethodSource("cases2")
    void verify2(String answer, String inputPath) {
        final String result = new SimplifyPath_71().simplifyPath2(inputPath);

        assertEquals(answer, result);
    }

    public static Stream<Arguments> cases2() {
        return Stream.of(
                Arguments.of("/.../b/d", "/.../a/../b/c/../d/./")
        );
    }
}