package org.kaidzen.study.leetcode.y2025.stackNqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MovingAverageFromDataStream_346 {

    private final int size;
    private final Deque<Integer> window;
    private final List<Integer> queue = new ArrayList<>();
    private int sum = 0;

    public MovingAverageFromDataStream_346( int size) {
        this.size = size;
        window = new ArrayDeque<>();
    }

    public double next(int val) {
        window.offer(val);
        int first = window.size() > size ? window.poll() : 0;
        sum += val - first;

        return 1.0 * sum / window.size();
    }

    public double next2(int val) {
        queue.add(val);
        int windowSum = 0;
        for (int i=Math.max(0, queue.size() - size); i < queue.size(); i++){
            windowSum += queue.get(i);
        }
        return (windowSum * 1.0) / Math.min(queue.size(), size);
    }
}
