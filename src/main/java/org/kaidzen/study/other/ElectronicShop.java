package org.kaidzen.study.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElectronicShop {

    public static void main(String[] args) {
        ElectronicShop shop = new ElectronicShop();

        System.out.println(shop.getMoneySpent(new int[]{3, 1}, new int[]{5, 2, 8}, 10));
        System.out.println(shop.getMoneySpent2(new int[]{3, 1}, new int[]{5, 2, 8}, 10));
    }

    int getMoneySpent(int[] keyboards, int[] drives, int b) {

        final int notFound = -1;
        Arrays.sort(keyboards);
        Arrays.sort(drives);

        int kLength = keyboards.length;
        int dLength = drives.length;

        if (keyboards[0] + drives[0] > b) {
            return notFound;
        }

        List<Integer> candidates = new ArrayList<>();

        for (int k = kLength-1; k>=0; k--){
            final int check = k - 1;
            int nextK = Math.max(check, 0);

            for (int d = dLength-1; d>0; d--){
                final int current = keyboards[k] + drives[d];
                if (current == b) {
                    return current;
                }
                if (current < b ) {
                    candidates.add(current);
                }
//                if (keyboards[k] + drives[d-1] < current){
//                }
            }
        }
        return candidates.stream()
                .max(Integer::compareTo)
                .orElse(notFound);
    }

    int getMoneySpent2(int[] keyboards, int[] drives, int b){
        Arrays.sort(keyboards);
        Arrays.sort(drives);

        int kLength = keyboards.length;
        int dLength = drives.length;
        int max = -1;

        if (keyboards[0] + drives[0] > b) {
            return max;
        }

        for(int i = 0; i < kLength; i++){
            for(int j = dLength-1; j > 0; j--){
                if(keyboards[i]+drives[j] > b) break; //This prevents j from incrementing
                if(keyboards[i]+drives[j] > max)
                    max = keyboards[i]+drives[j];
            }
        }
        return max;
    }
}
