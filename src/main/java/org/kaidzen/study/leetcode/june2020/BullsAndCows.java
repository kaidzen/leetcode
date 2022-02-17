package org.kaidzen.study.leetcode.june2020;

public class BullsAndCows {

    public static void main(String[] args) {
        BullsAndCows hintGame = new BullsAndCows();
//        Input: secret = "1807", guess = "7810"
//        Output: "1A3B"
//        Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
        String answer1 = hintGame.getHint("1807", "7810");
        System.out.println(answer1);
//        Input: secret = "1123", guess = "0111"
//        Output: "1A1B"
//        Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
        String answer2 = hintGame.getHint("1123", "0111");
        System.out.println(answer2);
//        Input: secret = "0194", guess = "9038"
//        Output: "1A1B"
//        Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
        String answer3 = hintGame.getHint("0194", "9038");
        System.out.println(answer3);
    }

    public String getHint(String secret, String guess) {
        int length = secret.length();
        if (length != guess.length()) {
            return "ERROR";
        }
        int bulls = 0;
        int cows = 0;
        int[] sIndx = new int[10];
        int[] gIndx = new int[10];

        for (int i = 0; i < length; i++) {
            char sChar = secret.charAt(i);
            char gChar = guess.charAt(i);
            if (sChar == gChar) {
                bulls++;
            } else {
                sIndx[sChar - '0']++;
                gIndx[gChar - '0']++;
            }
        }

        for (int i = 0; i < sIndx.length - 1; i++) {
            cows += Math.min(sIndx[i], gIndx[i]);
        }
        return String.format("%dA%dB", bulls, cows);
    }
}
