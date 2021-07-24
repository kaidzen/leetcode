package org.kaidzen.study.dsandalgo.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    private LinkedList<Integer> underTest;

    @BeforeEach
    void setUp() {
        underTest = new LinkedList<>();
    }

    @Test
    void appendLast() {
        assertEquals(0, underTest.length);

        Integer value = 10;
        underTest.appendLast(value);

        assertEquals(value, underTest.last.value);

        Integer otherValue = 1;
        underTest.appendFirst(otherValue);

        assertEquals(value, underTest.last.value);
    }

    @Test
    void appendFirst() {
        assertEquals(0, underTest.length);

        Integer value = 10;
        underTest.appendFirst(value);
        assertEquals(value, underTest.first.value);

        Integer otherValue = 1;
        underTest.appendLast(otherValue);

        assertEquals(value, underTest.first.value);
    }

    @Test
    void insert() {
        Integer first = 10;
        Integer second = 20;
        underTest.appendFirst(first);
        underTest.appendFirst(second);

        assertEquals(second, underTest.first.value);

        underTest.size();
        Integer otherValue = 30;
        underTest.insert(1, otherValue);

        assertEquals(second, underTest.first.value);
        assertEquals(3, underTest.size());
    }

    @Test
    void should_throw_exception_when_wrong_index_to_insert() {
        final String message = Assertions.assertThrows(IllegalArgumentException.class,
                () -> underTest.insert(-10, 0)).getMessage();

        assertEquals(message, "Invalid index for insertion");
    }

    @Test
    void should_throw_exception_when_wrong_index_to_search() {
        final String message = Assertions.assertThrows(IllegalArgumentException.class,
                () -> underTest.findAtIndex(-10)).getMessage();

        assertEquals(message, "Invalid index for search");
    }
}