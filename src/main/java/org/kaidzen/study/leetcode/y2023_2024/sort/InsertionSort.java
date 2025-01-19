package org.kaidzen.study.leetcode.y2023_2024.sort;

import java.util.Arrays;
import java.util.List;

/**
 * The Insertion Sort algorithm uses one part of the array to hold the sorted values,
 * and the other part of the array to hold values that are not sorted yet.
 * <p>
 * Take the first value from the unsorted part of the array.
 * Move the value into the correct place in the sorted part of the array.
 * Go through the unsorted part of the array again as many times as there are values
 */
public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertion = new InsertionSort();

        List<String> list1 = Arrays.asList("a", "c", "d", "b", "bb", "dda", "fvh");
        List<String> list2 = Arrays.asList("a", "c", "d", "b", "bb", "dda", "fvh");
        long start = System.nanoTime();
        System.out.println(insertion.sort(list1));
        System.out.println("Finished first: " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println(insertion.sort2(list2));
        System.out.println("Finished second: " + (System.nanoTime() - start));

    }

    public List<String> sort(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            String minElem = list.get(i);
            int j = i;
            while (j > 0 && minElem.compareTo(list.get(j - 1)) < 0) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, minElem);
        }
        return list;
    }

    public List<String> sort2(List<String> list) {
        final int length = list.size();
        for (int i = 1; i < length; i++) {
            String minElem = list.get(i);
            int minPos = i;
            for (int j = i + 1; j < length; j++) {
                if (list.get(j).compareTo(minElem) < 0) {
                    minPos = j;
                    minElem = list.get(minPos);
                }
            }
            if (minPos <= i) {
                list.set(minPos, list.get(i));
                list.set(i, minElem);
            }
        }
        return list;
    }
}
