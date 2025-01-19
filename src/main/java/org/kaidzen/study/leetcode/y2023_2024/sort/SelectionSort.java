package org.kaidzen.study.leetcode.y2023_2024.sort;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * The Selection Sort algorithm finds the lowest value in an array and moves it to the front of the array.
 * <p/>
 * Go through the array to find the lowest value.
 * Move the lowest value to the front of the unsorted part of the array.
 * Go through the array again as many times as there are values in the array.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[] {4,7,5,1,4,0,9,7};
        SecureRandom random = new SecureRandom();
//        array = IntStream.range(0, 100000)
//                .parallel()
//                .map(operand -> random.nextInt())
//                .toArray();
        long start = System.currentTimeMillis();
        SelectionSort.sort(array);
        long end = System.currentTimeMillis() - start;

        System.out.println(Arrays.toString(array));
        System.out.println("It takes: " + end);
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                    swap(array, i, minIdx);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
