package org.kaidzen.study.leetcode.june2020;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    public static void main(String[] args) {
        PowerOfTwo power = new PowerOfTwo();
//        Example 1:
//        Input: 1
//        Output: true
//        Explanation: 20 = 1
        System.out.println(power.isPowerOfTwo(1));
//        Example 2:
//        Input: 16
//        Output: true
//        Explanation: 24 = 16
        System.out.println(power.isPowerOfTwo(16));
//        Example 3:
//        Input: 218
//        Output: false
        System.out.println(power.isPowerOfTwo(218));
    }
}
