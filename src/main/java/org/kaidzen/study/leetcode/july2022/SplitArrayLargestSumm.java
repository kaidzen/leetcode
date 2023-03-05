package org.kaidzen.study.leetcode.july2022;

public class SplitArrayLargestSumm {

    public static void main(String[] args) {
        SplitArrayLargestSumm largest = new SplitArrayLargestSumm();

        int[] nums = new int[]{7,2,5,10,8};
        int m = 2;
        System.out.println("Largest sum: " + largest.splitArray(nums, m));

        int[] nums2 = new int[]{7,2,5,10,8};
        int m2 = 2;
        System.out.println("Largest sum2: " + largest.splitArray2(nums2, m2));
    }

    public int splitArray(int[] nums, int m) {
        int sum = 0;
        for (int num: nums){
            sum += num;
        }

        int leftSum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            int righSum = sum - leftSum;
            res = Math.max(leftSum, righSum);
        }
        return res;
    }

    public int splitArray2(int[] nums, int m) {
        int low = 0, high = 0;

        for (int n: nums) {
            low = Math.max(low, n);
            high += n;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (check(nums, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // check if it is possbile to split to m subarrays which each subarry's sum less than or equal to mid
    private boolean check(int[] nums, int m, int mid) {
        int sum = 0;
        int numOfSubarrays = 1;

        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                numOfSubarrays++;
                sum = num;
            }
        }

        return numOfSubarrays <= m;
    }
}
