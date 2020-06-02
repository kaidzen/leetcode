package org.kaidzen.leetcode;

import java.util.Arrays;
import java.util.List;


public class MinStack {

    private Unit top;

    public MinStack() {
        //empty
    }

    public void push(int x) {
        if (top == null) {
            top = new Unit(x, x);
        } else {
            Unit unit = new Unit(x, Math.min(x, top.min));
            unit.next = top;
            top = unit;
        }
    }

    public void pop() {
        if (top == null) {
            return;
        }
        Unit temp = top.next;
        top.next = null;
        top = temp;
    }

    public int top() {
        if (top == null) {
            return -1;
        }
        return top.value;
    }

    public int getMin() {
        if (top == null) {
            return -1;
        }
        return top.min;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-2, 0, -3);
        MinStack obj = new MinStack();
        list.forEach(obj::push);

        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }

    private class Unit {
        int value;
        int min;
        Unit next;

        Unit(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
