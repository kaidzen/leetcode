package org.kaidzen.study.leetcode.y2025.stackNqueue;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer
 * such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 *  Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 * Constraints:
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *
 */
public class DailyTemperatures_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        final String encoded = URLEncoder.encode("qqwe", StandardCharsets.UTF_8);
        int len = temperatures.length;
        int[] answer = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.element()] < temperatures[i]) {
                int j = stack.poll();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        return answer;
    }
}
