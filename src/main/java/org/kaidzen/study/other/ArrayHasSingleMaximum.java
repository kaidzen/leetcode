package org.kaidzen.study.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayHasSingleMaximum {

    public static void main(String[] args) {
        List<int[]> inputs = Arrays.asList(
                new int[]{1, 2, 3, 1, 0},
                new int[]{18},
                new int[]{1, 2, 3, 0, 1, 3},
                new int[]{13, 1, 13, 2, 13, 0, 13, 1, 13},
                new int[]{},
                new int[]{-6, -6, -6, -6, -6, -6, -6}
        );
        List<Integer> answers = Arrays.asList(1, 1, 0, 0, 0, 0);
        final int size = inputs.size();
        if (size != answers.size()) {
            System.err.println("Failed to check on different inputs and answers...");
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            System.out.println(hasSingleMaximum1(inputs.get(i)));
        }
        System.out.println("======");
        for (int i = 0; i < size - 1; i++) {
            System.out.println(hasSingleMaximum2(inputs.get(i)));
        }
    }

    private static int hasSingleMaximum1(int[] ints) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int num : ints) {
            map.merge(num, 1, (old, fresh) -> old + 1);
            max = Math.max(num, max);
        }
        if (max == Integer.MIN_VALUE) {
            return 0;
        }
        final Integer occurrence = map.get(max);
        return (occurrence == 1) ? 1 : 0;
    }

    private static int hasSingleMaximum2(int[] ints) {
        int max = Integer.MIN_VALUE;
        int counter = 0;
        final int length = ints.length;
        for (int i = 0; i < length; i++) {
            int num = ints[i];
            max = Math.max(num, max);
        }
        if (max == Integer.MIN_VALUE) {
            return 0;
        }
        for (int val : ints) {
            if (val == max) {
                counter++;
            }
        }
        return (counter == 1) ? 1 : 0;
    }
}
