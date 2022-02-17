package org.kaidzen.study.leetcode;

public class BeautifulArrangement {

    private int result = 0;

    public int countArrangement(int n) {
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        dfs(nums, 1);
        return result;
    }

    private void dfs(int[] nums, int index) {
        int length = nums.length;
        if (index == length) {
            result++;
            return;
        }

        for (int j = index; j < length; j++) {
            if (nums[j] % index == 0 || index % nums[j] == 0) {
                swap(nums, index, j);
                dfs(nums, index + 1);
                swap(nums, j, index);
            }
        }
    }

    private void swap(int[] nums, int first, int second) {
        if (second == first) {
            return;
        }
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {

    }
}
