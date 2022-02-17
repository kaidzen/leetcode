package org.kaidzen.study.other;

import java.util.Arrays;
import java.util.List;

public class BillDivision {

    public static void main(String[] args) {
        BillDivision divisions = new BillDivision();
        divisions.bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 7);
        divisions.bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 12);
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        final Integer sum = bill.stream()
                .reduce(0, Integer::sum);
        int perOne = (sum - bill.get(k)) / 2;

        final int actual = b - perOne;
        if (actual == 0) {
            System.out.println("Bon Appetit");
            ;
        } else {
            System.out.println(actual);
        }
    }
}
