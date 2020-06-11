package org.kaidzen.study.leetcode.june2020;

import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        //As 1 should be in the center of sorted array, we use it as pivot in quick-search.
        int pointer0 = 0;
        int pointer = 0;
        int pointer2 = nums.length - 1;
        //"<=", and not just "<" as wee need to swapped numbers
        while (pointer <= pointer2){
            //Swap current pointer with pointer of zeros (all numbers before it are "0")
            if (nums[pointer] == 0){
                nums[pointer] = nums[pointer0];
                nums[pointer0] = 0;
                pointer++;
                pointer0++;
            }else if (nums[pointer] == 2){
                //Swap current pointer with pointer of twos (all numbers after it are "2")
                nums[pointer] = nums[pointer2];
                nums[pointer2] = 2;
                pointer2--;
            }else {
                //Here is 1, so we skip it, as it pivotal
                pointer++;
            }
        }
    }

    public static void main(String[] args) {
        //Colors: 0 - red, 1 - white, 2 - green.
//        Input: [2,0,2,1,1,0]
//        Output: [0,0,1,1,2,2]
        SortColors sorter = new SortColors();
        int[] array = new int[]{2,0,2,1,1,0};
        sorter.sortColors(array);
        System.out.println(Arrays.toString(array));
    }
}
