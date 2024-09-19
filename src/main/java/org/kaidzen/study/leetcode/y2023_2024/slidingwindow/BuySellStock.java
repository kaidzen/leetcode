package org.kaidzen.study.leetcode.y2023_2024.slidingwindow;

public class BuySellStock {

    public static void main(String[] args) {

        BuySellStock stocks = new BuySellStock();

        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(stocks.maxProfit(prices)); //5

        int[] prices2 = new int[]{7,6,4,3,1};
        System.out.println(stocks.maxProfit(prices2)); //0

        int[] prices3 = new int[]{2,1,2,1,0,1,2};
        System.out.println(stocks.maxProfit(prices3)); //2
    }

    public int maxProfit(int[] prices) {
        int l = 0;
        int r = l+1;
        int length = prices.length;
        int maxDiff = 0;
        while (r < length){
            int left = prices[l];
            int right = prices[r];
            if (left < right){
                maxDiff = Math.max(maxDiff, right-left);
            } else if (left > right){
                l = r;
            }
            r++;
        }
        return maxDiff;
    }


}
