package org.kaidzen.study.leetcode.y2025.linkedlist;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kaidzen.study.leetcode.util.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseLinkedListII_92Test {

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(ListNode.of(new int[]{1,4,3,2,5}), ListNode.of(new int[]{1,2,3,4,5}), 2, 4)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("cases")
    public void verify(ListNode answer, ListNode head, int left, int right) {
        ListNode start = new ReverseLinkedListII_92().reverseBetween(head, left, right);

        //TODO fix logic
        assertEquals(answer, start);
    }
}