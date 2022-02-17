package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingElementsPlus1 {

    public static void main(String[] args) {
        List<int[]> list = Arrays.asList(
                new int[]{1, 2, 3},
                new int[]{1, 1, 3, 3, 5, 5, 7, 7},
                new int[]{1, 3, 2, 3, 5, 0},
                new int[]{1, 1, 2, 2}
        );
        CountingElementsPlus1 counter = new CountingElementsPlus1();
        list.forEach(
                ints -> System.out.println(counter.countElements(ints))
        );
    }

    public int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int elem : arr) {
            map.merge(elem, 1, (old, fresh) -> old + fresh);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (map.containsKey(key + 1)) {
                sum += map.getOrDefault(key, 0);
            }
        }
        return sum;
    }
}
