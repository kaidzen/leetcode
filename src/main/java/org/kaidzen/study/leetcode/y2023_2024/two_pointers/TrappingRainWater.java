package org.kaidzen.study.leetcode.y2023_2024.two_pointers;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater trapping = new TrappingRainWater();

        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapping.trap(height)); //6
        System.out.println(trapping.trap2(height)); //6

        int[] height2 = new int[]{4,2,0,3,2,5};
        System.out.println(trapping.trap(height2)); //9
        System.out.println(trapping.trap2(height2)); //9

    }
    //T: O(n), S: O(n)
    public int trap(int[] height) {
        int length = height.length;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        int[] min = new int[length];

        int maxL = Integer.MIN_VALUE;
        for (int l=1; l<length; l++){
            maxL = Math.max(maxL, height[l - 1]);
            maxLeft[l] = maxL;
        }
        int maxR = Integer.MIN_VALUE;
        for (int j=length - 2; j>=0; j--){
            maxR = Math.max(maxR, height[j+1]);
            maxRight[j] = maxR;
        }
        int sum = 0;
        for (int i=0; i < length; i++){
            min[i] = Math.min(maxLeft[i], maxRight[i]);
            int water = min[i] - height[i];
            sum += water >=0 ? water : 0;
        }
        return sum;
    }

    //T: O(n), S: O(1)
    public int trap2(int[] height) {
        final int length = height.length;
        if (0 == length) return 0;
        int l = 0;
        int r = length-1;
        int leftMax = height[l];
        int rightMax = height[r];
        int res = 0;
        while (l < r){
            if (leftMax <= rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
