package org.kaidzen.study.leetcode;

import java.util.Arrays;

public class RichestCustomerWealth {

    public static void main(String[] args) {
        int[][] accounts = new int[][]{{1, 2, 3}, {3, 2,}};

        RichestCustomerWealth richestCustomer = new RichestCustomerWealth();
        System.out.println(richestCustomer.maximumWealth(accounts));

    }

    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(internal -> Arrays.stream(internal).sum())
                .max()
                .orElse(-1);
    }
}
