package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.List;

public class BitwiseAndOfNumbers {

    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 7};
        int[] arr2 = new int[]{0, 1};

        BitwiseAndOfNumbers bitwizeAll = new BitwiseAndOfNumbers();

        List<int[]> list = Arrays.asList(arr1, arr2);
        list.forEach(ints -> System.out.println(bitwizeAll.rangeBitwiseAnd(ints[0], ints[1])));
    }
}
