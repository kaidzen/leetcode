package org.kaidzen.study.leetcode.y2025.stackNqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Classic stack with added getMin() functionality.
 * Implemented with 2 stack, second always has last added as min value.
 *
 */
public class MinStack_155 {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> stackMin = new ArrayDeque<>();

    public static void main(String[] args) {
        MinStack_155 minStack = new MinStack_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

        public MinStack_155() {
        }

        public void push(int val) {
            int min = Math.min(Integer.MAX_VALUE, val);
            if (!stack.isEmpty()) {
                min = Math.min(stackMin.peekLast(), min);
            }
            stack.offer(val);
            stackMin.offer(min);
        }

        public void pop() {
            stack.pollLast();
            stackMin.pollLast();
        }

        public int top() {
            if (stack.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return stack.peekLast();
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                return Integer.MIN_VALUE;
            } else {
                return stackMin.peekLast();
            }
        }
    }

/*
  Your MinStack object will be instantiated and called as such:
  MinStack obj = new MinStack();
  obj.push(val);
  obj.pop();
  int param_3 = obj.top();
  int param_4 = obj.getMin();
 */

