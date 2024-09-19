package org.kaidzen.study.leetcode.y2023_2024.two_pointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();

        int[] heghts = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(container.maxArea(heghts));

    }

    public int maxArea(int[] height) {
        int result = 0;
        int l = 0;
        int r = height.length-1;

        while (l<r){
            int area = (r-l) * Math.min(height[l], height[r]);

            result = Math.max(area, result);
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return result;
    }
}
