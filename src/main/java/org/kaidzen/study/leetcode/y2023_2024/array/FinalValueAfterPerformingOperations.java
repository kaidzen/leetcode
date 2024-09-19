package org.kaidzen.study.leetcode.y2023_2024.array;

public class FinalValueAfterPerformingOperations {

    public static void main(String[] args) {

        FinalValueAfterPerformingOperations find = new FinalValueAfterPerformingOperations();

        String[] operations = new String[]{"--X","X++","X++"};
        find.finalValueAfterOperations(operations);

    }

    public int finalValueAfterOperations(String[] operations) {

        int ans = 0;

        for(String op: operations){
            if (op.contains("+")){
                ans++;
            } else {
                ans--;
            }
        }


        return ans;
    }
}
