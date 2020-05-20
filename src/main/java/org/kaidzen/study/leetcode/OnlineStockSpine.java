package org.kaidzen.study.leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class OnlineStockSpine {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        List<Integer> list = Arrays.asList(100, 80, 60, 70, 60, 75, 85);
        list.forEach(integer -> System.out.println(stockSpanner.next(integer)));
    }
}

class StockSpanner {

    Deque<Pair<Integer, Integer>> stack = new LinkedList<>();
    int index;

    public StockSpanner() {
        index= -1;
    }

    public int next(int price) {
        index += 1;
        while (!stack.isEmpty() && stack.peek().getValue() <= price){
            stack.pop();
        }
        if (stack.isEmpty()){
            stack.push(new Pair<>(index, price));
            return index+1;
        }
        int result = stack.peek().getKey();
        stack.push(new Pair<>(index, price));
        return index - result;
    }
}
