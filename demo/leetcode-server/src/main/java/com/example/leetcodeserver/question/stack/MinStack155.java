package com.example.leetcodeserver.question.stack;

import java.util.Stack;

public class MinStack155 {
    Stack<Integer> minStack;
    Stack<Integer> normalStack;

    public MinStack155() {
        minStack = new Stack<>();
        normalStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(Integer integer) {
        normalStack.push(integer);
        minStack.push(Math.min(integer, minStack.peek()));
    }

    public Integer pop() {
        Integer pop = normalStack.pop();
        minStack.pop();
        return pop;
    }

    public Integer top() {
        return normalStack.peek();
    }

    public Integer getMin() {
        return minStack.peek();
    }

}
