package org.kaidzen.study.leetcode;

import java.util.*;

public class CreateTargetArrayTheGivenOrder {

    public static void main(String[] args) {

        CreateTargetArrayTheGivenOrder arrayGenerator = new CreateTargetArrayTheGivenOrder();



//        Input: nums = [0, 1,2,3,4], index = [0,1,2,2,1]
//        Output: [0,4,1,3,2]

        System.out.println(Arrays.toString(
                arrayGenerator.createTargetArray3(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})));

        String str = "015010101";
        int[] arr = new int[str.length()];


        for (char ch : str.toCharArray()) {
            arr[ch ^ 48]++;
        }
        System.out.println(Arrays.toString(arr));

        System.out.println(calculateOccurrence(str));
    }

    private static Map<Integer, Integer> calculateOccurrence(String word){
        Map<Integer, Integer> map = new HashMap<>();
        final int zero = 48;

        word.chars().boxed()
                .forEach(integer -> {
                    map.merge(integer ^ zero, 1, (ov, nv) -> ov+1);
                });
        return map;
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        final int length = nums.length;
        final int marker = Integer.MIN_VALUE;
        int[] target = new int[length];

        Arrays.fill(target, marker);

        for (int i = 0; i < length; i++) {
            int next = nums[i];
            final int currIndex = index[i];
            int currValue = target[currIndex];
            if (currValue == marker) {
                target[currIndex] = next;
            } else {
                int startIndex = currIndex;
                while (startIndex < length) {
                    int temp = target[startIndex];
                    target[startIndex] = next;
                    target[++startIndex] = temp;
                    next = target[startIndex + 1];
                }

            }
        }

        return target;
    }

    public int[] createTargetArray2(int[] nums, int[] index) {

        final int length = index.length;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i< length; i++)
            list.add(index[i],nums[i]);

        return list.stream()
                .mapToInt(value -> value)
                .toArray();
    }

    public int[] createTargetArray3(int[] nums, int[] index) {
        final int length = index.length;
        int[] result = new int[length];

        final int marker = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            result[i] = marker;
        }

        for (int i = 0; i < length; i++) {
            if (result[index[i]] == marker){
                for(int j=i; j>index[i]; j--){
                    result[j] = result[j-1];
                }
                result[index[i]] = nums[i];
            } else {
                result[index[i]] = nums[i];
            }
        }
        return result;
    }
}
