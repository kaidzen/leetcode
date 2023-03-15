package org.kaidzen.study.leetcode.y2023.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicates {

    public static void main(String[] args) {
        ContainsDuplicates duplicates = new ContainsDuplicates();
        int [] nums1 = {1,2,3,1};
        System.out.println(duplicates.containsDuplicate1(nums1));
        System.out.println(duplicates.containsDuplicate2(nums1));
    }

    public boolean containsDuplicate1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums){
            map.merge(num, 1, (a,b) -> a + b);
        }
        for (int value: map.values()){
            if (value > 1) return true;
        }

        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int num : nums){
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
