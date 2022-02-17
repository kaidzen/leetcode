package org.kaidzen.study.leetcode;

import java.util.*;

public class MajorityElement {

    public int majorityElement2(int[] nums) {
        int candidate = 0;
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else {
                if (candidate == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i = 0; i < length; i++) {
            if (candidate == nums[i]) {
                count++;
            }
        }
        return count > length / 2 ? candidate : -1;
    }

    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int num : nums) {
            map.merge(num, 1, (old, fresh) -> old + 1);
        }
        Map.Entry<Integer, Integer> entry = map.entrySet().stream()
                .filter(entity -> entity.getValue() > length / 2)
                .findFirst()
                .orElse(null);
        return Objects.isNull(entry) ? -1 : entry.getKey();
    }

    public static void main(String[] args) {
//        Input: [3,2,3]
//        Output: 3
//        Input: [2,2,1,1,1,2,2]
//        Output: 2
        MajorityElement majority = new MajorityElement();
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        List<int[]> list = Arrays.asList(nums1, nums2);
        list.forEach(nums -> System.out.println(majority.majorityElement(nums)));
        System.out.println("====");
        list.forEach(nums -> System.out.println(majority.majorityElement2(nums)));
    }
}
