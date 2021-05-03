package org.kaidzen.study.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class CountSmallerAfterSelf {

    private static final SortedMap<Integer, Integer> indexesOfNumber = new TreeMap<>();

    public static void main(String[] args) {
        List<int[]> list = Arrays.asList(
                new int[]{5, 2, 6, 1},
                new int[]{-1},
                new int[]{-1, -1},
                new int[]{-1, 0}
        );
        List<int[]> answers = Arrays.asList(
                new int[]{2,1,1,0},
                new int[]{0},
                new int[]{0,0},
                new int[]{0,0}
        );

        CountSmallerAfterSelf smaller = new CountSmallerAfterSelf();

//        list.forEach(
//                arr -> System.out.println(smaller.countSmaller1(arr))
//        );
        list.forEach(
                arr -> System.out.println(smaller.countSmaller2(arr))
        );
    }

    //Time limit exceeded
    public List<Integer> countSmaller1(int[] nums) {
        indexesOfNumber.clear();
        final int length = nums.length;
        Deque<Integer> counts = new ArrayDeque<>(length);
        for (int j = length-1; j>=0; j--){
            int current = nums[j];
            indexesOfNumber.merge(current, 1, (ol, nw) -> ol + 1);
            countIt(current, counts);
        }
        return new ArrayList<>(counts);
    }

    public List<Integer> countSmaller2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        final int length = nums.length;
        Deque<Integer> counts = new ArrayDeque<>(length);
        for (int i=0, j = length-1; j>=0 && i < length; j--, i++){
            min = Math.min(Math.min(nums[i], nums[j]), min);
            max = Math.max(Math.max(nums[i], nums[j]), max);

        }

        BinaryIndexedTree tree = new BinaryIndexedTree(min, max);
        System.out.println("Min: " +min+ ", Max: " +max);
        for (int i = length-1; i >=0 ; i--) {
            final int current = nums[i];
            counts.offerFirst(tree.count(current - 1));
            tree.increment(current);
        }
        return new ArrayList<>(counts);
    }

    private static final class BinaryIndexedTree {

        private final int lower;
        private final int[] tree;

        BinaryIndexedTree(int lower, int higher) {
            this.lower = lower;
            this.tree = new int[higher - lower + 2];
        }

        void increment(int num) {
            int idx = num - lower + 1;

            while (idx < tree.length) {
                tree[idx]++;
                idx += idx & -idx;
            }
        }

        int count(int num) {
            int idx = num - lower + 1;
            int count = 0;

            while (idx > 0) {
                count += tree[idx];
                idx -= idx & -idx;
            }

            return count;
        }
    }

    private void countIt(int current, Deque<Integer> counts) {
        final Integer firstKey = indexesOfNumber.firstKey();
        if (current > firstKey){
            final int sum = IntStream.rangeClosed(firstKey, current - 1).boxed()
                    .mapToInt(key -> indexesOfNumber.getOrDefault(key, 0))
                    .sum();
            counts.offerFirst(sum);
        } else {
            counts.offerFirst(0);
        }
    }
}
