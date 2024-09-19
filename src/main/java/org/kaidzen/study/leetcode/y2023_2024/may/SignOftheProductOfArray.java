package org.kaidzen.study.leetcode.y2023_2024.may;

public class SignOftheProductOfArray {

    public static void main(String[] args) {
        SignOftheProductOfArray sign = new SignOftheProductOfArray();

//        int[] nums = new int[]{41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
//        System.out.println(sign.arraySign(nums));

        int[] nums2 = new int[]{9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        System.out.println(sign.arraySign(nums2));
    }

    public int arraySign(int[] nums) {
        long product = 1;
        for (int num : nums) {
            product *= num;
        }
        System.out.println("Product: " + product);
        System.out.println("LONG:    " + Long.MAX_VALUE);
        return Long.compare(product, 0);
    }
}
