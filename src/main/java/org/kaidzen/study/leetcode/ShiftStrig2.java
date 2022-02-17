package org.kaidzen.study.leetcode;

public class ShiftStrig2 {

    public String stringShift(String s, int[][] shift) {
        int rotations = 0;
        for (int[] arr : shift) {
            if (arr[0] == 0) {
                rotations += arr[1];
            } else {
                rotations -= arr[1];
            }
        }
        rotations = rotations % s.length();
        if (rotations > 0) {
            s = s.substring(rotations) + s.substring(0, rotations);
        } else if (rotations < 0) {
            s = s.substring(s.length() - Math.abs(rotations)) + s.substring(0, s.length() - Math.abs(rotations));
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "abc";
        int[][] shift = {{0, 1}, {1, 2}};
        String s2 = "abcdefg";
        int[][] shift2 = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};

        ShiftStrig2 sShift = new ShiftStrig2();

        System.out.println(sShift.stringShift(s, shift));
        System.out.println(sShift.stringShift(s2, shift2));
    }
}
