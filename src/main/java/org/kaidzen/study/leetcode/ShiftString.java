package org.kaidzen.study.leetcode;

public class ShiftString {

    public String stringShift(String s, int[][] shift) {
        int left = 0;
        int right = 0;
        for (int[] arr : shift) {
            if (arr[0] == 0) {
                left += arr[1];
            } else if (arr[0] == 1) {
                right += arr[1];
            }
        }
        int amount;
        if (right - left > 0) { //right
            amount = right - left;
            while (amount-- > 0) {
                s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
            }
        } else if (right - left < 0) { //left
            amount = left - right;
            while (amount-- > 0) {
                s = s.substring(1, s.length()) + s.charAt(0);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "abc";
        int[][] shift = {{0, 1}, {1, 2}};
        String s2 = "abcdefg";
        int[][] shift2 = {{1,1},{1,1},{0,2},{1,3}};

        ShiftString sShift = new ShiftString();

        System.out.println(sShift.stringShift(s, shift));
        System.out.println(sShift.stringShift(s2, shift2));
    }
}
