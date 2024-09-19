package org.kaidzen.study.codesignal;

import java.util.Arrays;

public class ArrayChange {

    int solution(int[] inputArray) {
        int moves = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] >= inputArray[i+1]) {
                int diff = inputArray[i] - inputArray[i+1] +1; //find missed difference;
                moves += diff;
                inputArray[i+1] += diff; //increase sequence element;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        ArrayChange change = new ArrayChange();

        int[] inputArray = new int[]{1,1,1};
        System.out.println(change.solution(inputArray));

        String inputString = "1.1.1.1a";
        String[] split = inputString.split("\\.");

        System.out.println(Arrays.toString(split));

        System.out.println(split.length == 4);
    }
}
