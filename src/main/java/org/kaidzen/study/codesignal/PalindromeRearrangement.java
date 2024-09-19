package org.kaidzen.study.codesignal;

public class PalindromeRearrangement {

    boolean solution(String inputString) {
        // 1 odd, all even characters
        int[] dict = new int[26];

        for (char ch: inputString.toCharArray()) {
            int idx = ch-'a';
            dict[idx]++;

        }

        int oddCounter = 0;
        for (int num : dict) {
            if (num % 2 != 0) oddCounter++;
        }
        return oddCounter <= 1;
    }

    public static void main(String[] args) {
        PalindromeRearrangement rearranging = new PalindromeRearrangement();

        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbccccaaaaaaaaaaaaa";

        System.out.println(rearranging.solution(str));
    }
}
