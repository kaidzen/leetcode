package org.kaidzen.study.leetcode.june2020;

public class RandomPickWithWeight {

    private int[] weights;
    private int sum = 0;

    public RandomPickWithWeight(int[] w) {
        int length = w.length;
        weights = new int[length];
        for (int i = 0; i<length; i++){
            sum += w[i];
            weights[i] = sum;
        }
    }

    public int pickIndex() {
        int idx = (int) (Math.random() * sum);
        return binarySearch(idx + 1);
    }

    private int binarySearch(int idx) {
        int left = 0;
        int right = weights.length - 1;
        while (left < right){
            int mid = left + (right - left)/2;
            if (weights[mid] < idx){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }
}
