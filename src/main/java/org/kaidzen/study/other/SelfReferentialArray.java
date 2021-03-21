package org.kaidzen.study.other;

import java.util.Arrays;
import java.util.List;

public class SelfReferentialArray {

    public static void main(String[] args) {
        List<int[]> inputs = Arrays.asList(
                new int[]{1,2,1,0},
                new int[]{2,0,2,0},
                new int[]{2,1,2,0,0},
                new int[]{3,2,1,1,0,0,0},
                new int[]{4,2,1,0,1,0,0,0,},
                new int[]{5,2,1,0,0,1,0,0,0},
                new int[]{6,2,1,0,0,0,1,0,0,0},
                new int[]{2,0,0},
                new int[]{0}
        );
        List<Integer> answers = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 0, 0);
        final int size = inputs.size();
        if (size != answers.size()) {
            System.err.println("Failed to check on different inputs and answers...");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(isSelfReferential(inputs.get(i)));
        }
        System.out.println("======");
    }

    private static int isSelfReferential(int[] ints) {
        int[] helper = new int[ints.length];
        for (int i = 0; i < ints.length; i++){
            helper[i] = ints[i];
        }
        for (int val : ints) {
            helper[val]--;
        }
        for (int count : helper) {
            if (count != 0){
                return 0;
            }
        }
        return 1;
    }
}
