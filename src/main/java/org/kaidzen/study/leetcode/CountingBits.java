package org.kaidzen.study.leetcode;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int num) {
        int[] bitsCount = new int[num+1];
        for (int i=1; i<=num; i++){
            bitsCount[i] = bitsCount[i>>1] + i%2;
        }
        return bitsCount;
    }

    public static void main(String[] args) {
        CountingBits counting = new CountingBits();
//        Input: 2
//        Output: [0,1,1]
        System.out.println(Arrays.toString(counting.countBits(2)));
    }
}
