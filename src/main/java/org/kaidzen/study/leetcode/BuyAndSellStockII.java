package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.List;

public class BuyAndSellStockII {

    public static void main(String[] args) {

        List<int[]> list = Arrays.asList(
            new int[] {7, 1, 5, 3, 6, 4},
            new int[] {1,2,3,4,5},
                new int[] {7,6,4,3,1}
        );
        BuyAndSellStockII stock = new BuyAndSellStockII();
        list
                .forEach(ints -> System.out.println(stock.getMaxProfit(ints)));
    }

    public int getMaxProfit(int[] prices) {
        int low = 0;
        int high = 0;
        int i = 0;
        int maxProfit = 0;

        while (i< prices.length-1){
            while (i < prices.length-1 && prices[i] >= prices[i+1]){
                i++;
            }
            low = prices[i];
            while (i < prices.length-1 && prices[i+1] >= prices[i]){
                i++;
            }
            high = prices[i];

            maxProfit += high - low;
        }
        return maxProfit;
    }
}
