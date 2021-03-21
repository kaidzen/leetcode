package org.kaidzen.study.other;

import java.util.Arrays;
import java.util.List;

public class MartianArray {

    private static int oneCounter = 0;
    private static int twoCounter = 0;

    public static void main(String[] args) {
        List<int[]> inputs = Arrays.asList(
                new int[]{1, 3},
                new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1},
                new int[]{1, 3, 2},
                new int[]{1, 3, 3, 2, 1},
                new int[]{1, 2, -18, -18, 1, 2},
                new int[]{},
                new int[]{1},
                new int[]{2}
        );
        List<Integer> answers = Arrays.asList(1, 1, 0, 0, 0, 0, 1, 0);
        final int size = inputs.size();
        if (size != answers.size()) {
            System.err.println("Failed to check on different inputs and answers...");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(isMartian(inputs.get(i)));
        }
        System.out.println("======");
    }

    private static int isMartian(int[] ints) {
        oneCounter = 0;
        twoCounter = 0;
        final int length = ints.length;

        if (length < 1) {
            return 0;
        }
        countCandidates(ints[0]);
        for (int i = 1; i < length; i++) {
            int first = ints[i-1];
            int second = ints[i];
            if (first == second) {
                return 0;
            }
            countCandidates(second);
        }
        return oneCounter > twoCounter ? 1 : 0;
    }

    private static void countCandidates(int value) {
        if (value == 1){
            oneCounter += 1;
        } else if (value == 2){
            twoCounter += 1;
        }
    }
}
