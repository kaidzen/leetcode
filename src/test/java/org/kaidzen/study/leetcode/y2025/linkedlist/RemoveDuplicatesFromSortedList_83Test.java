package org.kaidzen.study.leetcode.y2025.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kaidzen.study.leetcode.util.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedList_83Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(ListNode.of(new int[]{1, 2}), ListNode.of(new int[]{1, 1, 2}))
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void verify(ListNode answer, ListNode head) {
        final ListNode result = new RemoveDuplicatesFromSortedList_83().deleteDuplicates(head);
        assertEquals(answer, result);
    }
}