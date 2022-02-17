package org.kaidzen.study.leetcode;

public class NumberCompliment {

    public int findComplement(int num) {
        int bitLength = (int) (Math.log(num) / Math.log(2) + 1);
        int bitMask = (1 << bitLength) - 1; // Move 1 * times left 1000 -> revers bits 1000 - 1 = 0111

        return num ^ bitMask;
    }

    public static void main(String[] args) {
//        Input:    5 (0101)
//        Output:   2 (0010)
//        Input:    1 (0001)
//        Output:   0 (0000)
        NumberCompliment compliment = new NumberCompliment();
        System.out.println(compliment.findComplement(5));
        System.out.println(compliment.findComplement(1));
    }
}
