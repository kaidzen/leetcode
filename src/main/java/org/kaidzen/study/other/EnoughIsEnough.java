package org.kaidzen.study.other;

import java.util.*;

public class EnoughIsEnough {

    public static void main(String[] args) {
        EnoughIsEnough enough = new EnoughIsEnough();
        int[] res = enough.deleteNth(new int[]{20, 37, 20, 21}, 0);
        System.out.println(Arrays.toString(res));

        int[] res1 = enough.deleteNth(new int[]{26, 3, 4, 20, 35, 15, 1, 40, 2, 16, 32, 37, 12, 23, 7, 5, 2, 8, 19, 33, 15, 31, 7, 10, 30, 36, 15, 3, 40, 30, 34, 7, 38, 15, 2, 6, 22, 20, 7, 30, 23, 23, 17}, 1);
        System.out.println(Arrays.toString(res1));
    }

    public int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> map = new HashMap<>();

        // fulfill occurrences, with corner case Zero one
        for (int el : elements) {
            map.merge(el, maxOccurrences > 0 ? 1 : 0, (old, nw) -> {
                if (old < maxOccurrences) {
                    return old + 1;
                }
                return maxOccurrences > 0 ? old : 0;
            });
        }
        List<Integer> result = new ArrayList<>();
        //Producing result according to occupancies map
        for (int i = 0; i < elements.length; i++) {
            final int element = elements[i];
            if (map.containsKey(element) && map.get(element) != 0) {
                result.add(element);
            }
        }

        return result.stream()
                .mapToInt(a -> a)
                .toArray();
    }
}
