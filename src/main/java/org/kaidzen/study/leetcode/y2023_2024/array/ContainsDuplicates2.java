package org.kaidzen.study.leetcode.y2023_2024.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicates2 {

    public static void main(String[] args) {
        ContainsDuplicates2 duplicates = new ContainsDuplicates2();
        int [] nums1 = {1,2,3,1};
        int k1 = 3;
        System.out.println(duplicates.containsNearbyDuplicate1(nums1, k1));
        System.out.println(duplicates.containsNearbyDuplicate2(nums1, k1));

        int [] nums2 = {1,2,3,1,2,3};
        int k2 = 2;
        System.out.println(duplicates.containsNearbyDuplicate1(nums2, k2));
        System.out.println(duplicates.containsNearbyDuplicate2(nums2, k2));
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        final int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);

        for (int i=0; i < length; i++) {
            final int value = nums[i];
            if (map.containsKey(value)) {
                if (Math.abs(map.get(value) - i) <= k) return true;
            }
            map.put(value, i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> window =new HashSet<>();
        for (int i=0; i< nums.length; i++){
            if(i <= k){
                window.add(nums[i]);
                if (window.size() < i+1){
                    return true;
                }

            } else {
                window.remove(nums[i-k-1]);
                window.add(nums[i]);
                if (window.size() <= k) return true;
            }
        }
        return false;
    }
}
