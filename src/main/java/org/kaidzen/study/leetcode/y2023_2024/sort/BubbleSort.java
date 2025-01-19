package org.kaidzen.study.leetcode.y2023_2024.sort;

import java.util.Arrays;

/**
 * Go through the array, one value at a time.
 * For each value, compare the value with the next value.
 * If the value is higher than the next one, swap the values so that the highest value comes last.
 * Go through the array as many times as there are values in the array.
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubble = new BubbleSort();

        int[] array = new int[] {64, 34, 25, 12, 22, 11, 90, 5};
        bubble.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] source) {
        final int length = source.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-1; j++) {
                if (source[j] > source[j+1]) {
                    int temp = source[j];
                    source[j] = source[j+1];
                    source[j+1] = temp;
                }
            }
        }
    }
}
