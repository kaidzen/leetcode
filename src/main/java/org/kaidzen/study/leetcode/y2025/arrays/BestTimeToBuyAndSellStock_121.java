package org.kaidzen.study.leetcode.y2025.arrays;

public class BestTimeToBuyAndSellStock_121 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_121 bt = new BestTimeToBuyAndSellStock_121();

        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(bt.maxProfit(prices));
    }

    /**
     * 2 pointers approach. Actually, while contains sub-loop (for each left pointer we combine it
     * with each that left by right pointer)
     * @param prices input prices day by day
     * @return maximum profit, that we can get
     */
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxPr = 0;
        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxPr = Math.max(maxPr, profit);
            } else {
                l = r;
            }
            r++;
        }
         return maxPr;
    }
}
