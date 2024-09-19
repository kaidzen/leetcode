package org.kaidzen.study.dsandalgo.list;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class Worksheet {

    @Test
    void charset() {
        IntStream.rangeClosed(65, 122)
                .mapToObj(n -> (char) n)
                .forEach(System.out::println);
    }

    @Test
    void single_char() {

        System.out.println(Character.valueOf( (char) 65));
        System.out.println(Character.forDigit(65, 8));
    }


}
