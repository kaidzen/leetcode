package org.kaidzen.study.leetcode.y2025.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    public static void main(String[] args) {
        MajorityElement_169 majEl = new MajorityElement_169();

        int[] arr = new int[] {2,2,1,1,1,2,2};
        System.out.println(majEl.majorityElement(arr)); //2

        int[] arr2 = new int[] {3,2,3};
        System.out.println(majEl.majorityElement2(arr2)); //3

        System.out.println(majEl.majorityElement3(arr)); //2

        System.out.println(majEl.majorityElement4(arr)); //2
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int rank = nums.length / 2;

        for (int el : nums) {
            map.merge(el, 1, (a, b) -> a + 1);
        }

        return map.entrySet().stream()
                .reduce(
                        Map.entry(Integer.MIN_VALUE, Integer.MIN_VALUE),
                        (current, entry) -> entry.getValue() > rank ? entry : current
                ).getKey();

    }

    /**
     * With usage of hashmap. Optimized while populating hashmap
     * T = O(n)
     * S = O(n)
     * @param nums input array
     * @return major element
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int rank = nums.length / 2;
        int res = Integer.MIN_VALUE;
        int majority = 0;

        for (int el : nums) {
            map.merge(el, 1, (a, b) -> a + 1);
            if (map.get(el) > majority) {
                res = el;
                majority = map.get(el);
            }
        }
        return res;
    }

    public int majorityElement3(int[] nums) {
        int rank = nums.length / 2;
        int res = Integer.MIN_VALUE;
        int count = 0;

        for (int el : nums) {

            if (count == 0) {
                res = el;
            }
            if (res == el) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

    /**
     * Based on Boyer-Moore algo.
     * Here is not the most common, but majority element should be found
     * T = O(n)
     *
     * @param nums
     * @return
     */
    public int majorityElement4(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num: nums) {
            if (count == 0) {
                res = num;
            }
            if (num == res) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }


}
