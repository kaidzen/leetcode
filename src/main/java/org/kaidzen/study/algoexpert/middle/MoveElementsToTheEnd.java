package org.kaidzen.study.algoexpert.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoveElementsToTheEnd {

    public static void main(String[] args) {
        List<Integer> arr = List.of(2, 1, 2, 2, 2, 3, 4, 2);
        List<Integer> res = MoveElementsToTheEnd.moveElementToEnd2(arr, 2);

        System.out.println(res);

        List<Integer> arr1 = List.of(1, 2, 4, 5, 6);
        List<Integer> res1 = MoveElementsToTheEnd.moveElementToEnd(arr1, 3);

        System.out.println(res1);

        List<Integer> arr2 = List.of(3, 3, 3, 3, 3);
        List<Integer> res2 = MoveElementsToTheEnd.moveElementToEnd2(arr2, 3);

        System.out.println(res2);
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        final Map<Boolean, List<Integer>> collect = array.stream().collect(Collectors.groupingBy(num -> num.equals(toMove)));
        System.out.println(collect);

        return Stream.concat(
                collect.getOrDefault(true, new ArrayList<>()).stream(),
                collect.getOrDefault(false, new ArrayList<>()).stream())
                .collect(Collectors.toList());
    }

    public static List<Integer> moveElementToEnd2(List<Integer> array, int toMove) {
        int i = 0;
        int j = array.size()-1;
        List<Integer> res = new ArrayList<>(array);
        while (i < j) {
            while (res.get(j) == toMove && j >= i) {
                j--;
            }
            if (res.get(i) == toMove) {
                int temp = res.get(j);
                res.set(j, res.get(i));
                res.set(i, temp);
            }
            i++;
        }

        return array;
    }
}
