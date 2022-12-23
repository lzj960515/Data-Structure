package com.solution.medium;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Integer min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0);
            min = x;
        } else {
            stack.push(x - min);
            min = Math.min(x, min);
        }
    }
    
    public void pop() {
        if (stack.peek() < 0) {
            min = min - stack.pop();
            return;
        }
        stack.pop();
    }
    
    public int top() {
        if (stack.peek() > 0) {
            return min + stack.peek();
        } else {
            return Math.toIntExact(min);
        }
    }
    
    public int min() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(1);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}
