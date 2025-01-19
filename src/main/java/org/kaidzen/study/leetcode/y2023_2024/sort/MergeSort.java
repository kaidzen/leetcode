package org.kaidzen.study.leetcode.y2023_2024.sort;

/*
Given a sorted array. Then one element was removed and rest were shafted.
Find missed element
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort sherlok = new MergeSort();

        int[] array = new int[] {10, 6, 8, 5, 7, 3, 4};
        System.out.println(sherlok.find(array));
        int len = array.length;
        int expectedSum = len * (len + 1) / 2;
        int currSum = 0;
        for (int i = 0; i < array.length; i++) {
            currSum += array[i];
        }
        System.out.println(expectedSum - currSum);
    }


    public int find(int[] array) {
        Set<String> set = new HashSet<>();

        int result = Integer.MIN_VALUE;

        sort(array);
        System.out.println(Arrays.toString(array));
        return result;
    }

    private void sort(int[] array) {
        int len = array.length;
        mergeSort(array, len);
    }

    private void mergeSort(int[] array, int len) {
        if (len < 2) {
            return;
        }
        int mid = len / 2;

        int[] l = new int[mid];
        int[] r = new int[len - mid];

        System.arraycopy(array, 0, l, 0, mid);
        System.arraycopy(array, mid, r, 0, len-mid);

        mergeSort(l, mid);
        mergeSort(r, len - mid);

        merge(array, l, r, mid, len - mid);
    }

    private void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r [j]) {
                array[k++] = l[i++];
            } else {
                array[k++] = r[j++];
            }
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }
}


