package org.kaidzen.study.hackerrank;

import java.util.List;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positive = 0;
        int negative = 0;
        int zero = 0;
        int amount = 0;

        for (Integer integer : arr) {
            if (integer == 0) {
                zero++;
            } else if (integer > 0) {
                positive++;
            } else {
                negative++;
            }
            amount++;
        }


        System.out.println(String.format("%f", positive / (amount * 1.0)));
        System.out.println(String.format("%f", negative / (amount * 1.0)));
        System.out.println(String.format("%f", zero / amount * 1.0));

    }
}
