package org.kaidzen.study.leetcode.june2020;

import java.util.*;

public class InsertDeleteGetRandomDataStructure {

    private List<Integer> numbers;
    private final Map<Integer, Integer> map = new HashMap<>();

    public InsertDeleteGetRandomDataStructure() {
        this.numbers = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.get(val) == null){
            numbers.add(val);
            map.put(val, numbers.size()-1);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer candidateIdx = map.get(val);
        if (Objects.nonNull(candidateIdx)){
            int lastIndex = numbers.size() - 1;
            Integer lastElement = numbers.get(lastIndex);
            numbers.set(candidateIdx, lastElement);
            map.put(lastElement, candidateIdx);
            numbers.remove(lastIndex);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = (int) (Math.random() * numbers.size());
        return numbers.get(idx);
    }

    public static void main(String[] args) {

    }
}
