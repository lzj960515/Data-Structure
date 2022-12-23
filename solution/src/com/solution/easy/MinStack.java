package com.solution.easy;

class MinStack {
    int[] data;
    int[] minData;
    int size = 0;
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new int[10000];
        minData = new int[10000];
    }

    public void push(int x) {
        if(size == 0){
            minData[size] = x;
        }else if(x < min()){
            minData[size] = x;
        }else {
            minData[size] = min();
        }
        data[size++] = x;
    }

    public void pop() {
        data[--size] = 0;
        minData[size] = 0;
    }

    public int top() {
        return data[size-1];
    }

    public int min() {
        return minData[size-1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(14);
        System.out.println(minStack.min());
        System.out.println(minStack.min());
        minStack.push(-20);
        System.out.println(minStack.top());
        minStack.pop();
        minStack.push(10);
        minStack.push(-7);
        System.out.println(minStack.min());
    }
}