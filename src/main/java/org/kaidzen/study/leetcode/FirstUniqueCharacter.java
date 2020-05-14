package org.kaidzen.study.leetcode;

import java.util.*;

public class FirstUniqueCharacter {

    public int firstUniqChar3(String s) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }


    public int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            map.merge(current, 1, (old, fresh) -> old + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int birthdayCakeCandles(int[] arr) {
        long start = System.currentTimeMillis();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= arr.length - 1; i++) {
            map.merge(arr[i], 1, (integer, integer2) -> integer + 1);
        }

        int max = 0;
        for (int num : arr) {
            Integer current = map.get(num);
            if (current > max) {
                max = current;
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println("It takes: " + (stop - start));
        return max;
    }

    public int birthdayCakeCandles2(int[] arr) {
        long start = System.currentTimeMillis();
        int[] newArr = Arrays.copyOf(arr, arr.length);

        Arrays.sort(newArr);
        int max = 1;
        for(int i = newArr.length - 1 ; i > 0; i--){
            if(newArr[i] == newArr[i-1]) max++;
                else break;
        }

        List<Integer> list = Arrays.asList(1,2,4,5,7,8);
        for (int val: list) {
            val++;
        }

        list.forEach(something -> System.out.println(something));

        long and_prize_going = list.stream()
                .peek(val -> System.out.println("Before filter: " + val))
                .filter(integer -> {
                    System.out.println("And prize going");
                    return integer % 2 == 0;
                })
                .peek(integer -> System.out.println("After filtering: " + integer))
                .count();

        long stop = System.currentTimeMillis();
        System.out.println("It takes: " + (stop - start));
        return max;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            map.merge(current, i, (old, fresh) -> -1);
        }

        int min = Integer.MAX_VALUE;
        for (char ch : s.toCharArray()) {
            Integer index = map.get(ch);
            if (index > -1 && index < min) {
                min = index;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        //s = "leetcode" => 0
//        s = "loveleetcode" => 2

        FirstUniqueCharacter unique = new FirstUniqueCharacter();

        System.out.println(unique.firstUniqChar3("leetcode"));
        System.out.println(unique.firstUniqChar3("loveleetcode"));

        System.out.println("Longest candles count: " + unique.birthdayCakeCandles(new int[]{3, 2, 1, 3, 3}));

        int top = 100000000;
        int valueTop = 100000;
        Random rnd = new Random(0);
        int[] range = rnd.ints(1, valueTop)
                .limit(top)
                .toArray();
        System.out.println("Longest candles count: " + unique.birthdayCakeCandles(range));

        System.out.println("Longest candles count: " + unique.birthdayCakeCandles2(new int[]{3, 2, 1, 3, 3}));

//        int top = 100000000;
//        int valueTop = 100000;
//        Random rnd = new Random(0);
//        int[] range = rnd.ints(1, valueTop)
//                .limit(top)
//                .toArray();
//        System.out.println("Longest candles count: " + unique.birthdayCakeCandles2(range));
    }
}
