package org.kaidzen.study.leetcode.y2025.hashtables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Finding duplicate. Bruteforce and sliding window implementation
 * Within sliding window approach HashSet set used as "window", defined for search range.
 */
public class ContainsDuplicate2_219 {

    public static void main(String[] args) {
        ContainsDuplicate2_219 cd = new ContainsDuplicate2_219();

        String example = "containsDuplicate2_219.txt";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        List<Integer> ints;

        try(final InputStream stream = loader.getResourceAsStream(example)) {
            ints = new BufferedReader(new InputStreamReader(stream)).lines()
                    .map(s -> s.split(","))
                    .flatMap(strings -> Arrays.stream(strings).map(Integer::valueOf))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read data from " + example, e);
        }
        final int size = ints.size();
        int[] nums = new int[size];
        int k;
        for (int i = 0; i < size; i++) {
            nums[i] = ints.get(i);
        }
        long start = System.currentTimeMillis();
        k = 612;
        System.out.println(cd.containsNearbyDuplicate(nums, k)); // false;
        long end = System.currentTimeMillis();
        System.out.printf("Size: %d and it takes: %d%n",size, end - start);

        int[] num = new int[]{1,0,1,1};
        k = 1;
        System.out.println(cd.containsNearbyDuplicate(num, k)); // true;

        start = System.currentTimeMillis();
        k = 612;
        System.out.println(cd.containsNearbyDuplicate2(nums, k)); // false;
        end = System.currentTimeMillis();
        System.out.printf("Size: %d and it takes: %d%n",size, end - start);
    }

    /**
     * bruteforce approach
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        int l = 0;
        int r;

        while (l < len - 1) {
            r = l + 1;
            while (r < len && Math.abs(l - r) <= k) {
                if (nums[l] == nums[r]) {
                    return true;
                }
                r++;
            }
            l++;
        }
        return false;
    }

    /**
     * Sliding window approach
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int len = nums.length;
        int l = 0;
        Set<Integer> window = new HashSet<>();

        Map<Character[], List< List<String>>> map = new HashMap<>();

        Character[] key = new Character[0];
        Object remap;
        final List<List<String>> base = new ArrayList<>();
        base.add(new ArrayList<>());
        map.merge(key, base, (l1, l2) -> {
            l1.add(l2.get(0));
            return l1;
        });

        for (int r = 0; r < len; r++) {
            if (r - l > k) {
                window.remove(nums[l]);
                l++;
            }
            if (window.contains(nums[r])) {
                return true;
            }
            window.add(nums[r]);
        }
        return false;
    }
}
