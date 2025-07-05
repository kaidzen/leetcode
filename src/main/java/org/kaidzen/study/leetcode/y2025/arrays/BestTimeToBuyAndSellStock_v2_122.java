package org.kaidzen.study.leetcode.y2025.arrays;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 */
public class BestTimeToBuyAndSellStock_v2_122 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_v2_122 bt = new BestTimeToBuyAndSellStock_v2_122();

        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(bt.maxProfit(prices));
    }

    /**
     * Buy on low, sell on high. And just sum profits.
     * @param prices input prices
     * @return best profit, that can be achieved.
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
