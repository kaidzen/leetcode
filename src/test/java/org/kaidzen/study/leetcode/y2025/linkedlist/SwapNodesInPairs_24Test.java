package org.kaidzen.study.leetcode.y2025.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kaidzen.study.leetcode.util.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwapNodesInPairs_24Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(ListNode.of(new int[]{2,1,4,3}), ListNode.of(new int[]{1,2,3,4})),
                Arguments.of(ListNode.of(new int[]{}), ListNode.of(new int[]{})),
                Arguments.of(ListNode.of(new int[]{1}), ListNode.of(new int[]{1})),
                Arguments.of(ListNode.of(new int[]{2,1,3}), ListNode.of(new int[]{1,2,3}))
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void verify(ListNode answer, ListNode head) {
        final ListNode result = new SwapNodesInPairs_24().swapPairs(head);

        assertEquals(answer, result);
    }
}