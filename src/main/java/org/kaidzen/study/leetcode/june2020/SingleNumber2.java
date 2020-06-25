package org.kaidzen.study.leetcode.june2020;

public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        int result = 0;
        int numberOfRepetition = 3;
        //Representation of integer's 32 bits
        int[] bits = new int[32];
        for (int i=0; i<32; i++){
            for (int n: nums){
                bits[i] += n >> i & 1;
                bits[i] %= numberOfRepetition;
            }
        }
        for (int i=0; i<32; i++){
            result |= bits[i] << i;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber2 number = new SingleNumber2();
//        Input: [2,2,3,2]
//        Output: 3
        System.out.println(number.singleNumber(new int[]{2,2,3,2}));
    }
}
