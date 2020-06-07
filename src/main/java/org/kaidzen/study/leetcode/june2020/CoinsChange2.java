package org.kaidzen.study.leetcode.june2020;

public class CoinsChange2 {

    public int change2(int amount, int[] coins) {
        //Optimized. Just needed steps according to the value.
        int[] dpRow = new int[amount+1];
        dpRow[0] = 1;
        for (int value: coins){
            for (int j = value; j<=amount; j++){
                //Take any current and sum with previous step on coin's value back.
                dpRow[j] += dpRow[j-value];
            }
        }
        return dpRow[amount];
    }
    public int change(int amount, int[] coins) {
        int[][] dpMatrix = new int[coins.length+1][amount+1];
        for (int i=0; i<=coins.length; i++){
            for (int j=0; j<=amount; j++){
                if (j==0){
                    //First column is extra, for "nothing"
                    dpMatrix[i][j] = 1;
                }else if (i == 0){
                    //First column with "nothing" always zero
                    dpMatrix[i][j] = 0;
                }else {
                    //Value will be: upper cell plus value in current row, with coin's value previous step.
                    // Use 0, if previous (on coin's value back) is 0
                    dpMatrix[i][j] = dpMatrix[i-1][j] + (j-coins[i-1] < 0 ? 0 : dpMatrix[i][j-coins[i-1]]);
                }
            }
        }
        return dpMatrix[coins.length][amount];
    }

    public static void main(String[] args) {
//        Input: amount = 5, coins = [1, 2, 5]
//        Output: 4
//        Explanation: there are four ways to make up the amount:
//        5=5
//        5=2+2+1
//        5=2+1+1+1
//        5=1+1+1+1+1
        CoinsChange2 coinsChanger = new CoinsChange2();
        int changeVariations = coinsChanger.change(5, new int[]{1, 2, 5});
        System.out.println(changeVariations);
        int changeVariations2 = coinsChanger.change2(5, new int[]{1, 2, 5});
        System.out.println(changeVariations2);
    }
}
