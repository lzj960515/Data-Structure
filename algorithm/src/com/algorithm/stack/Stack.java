package com.algorithm.stack;

public class Stack<E> { //自定义栈
    private Object[] data;
    private int size;

    public Stack(int capacity) {
        data = new Object[capacity];
    }

    //压栈
    public void push(E e) {
        if(size == data.length) throw new IndexOutOfBoundsException();
        data[size++] = e;
    }

    @SuppressWarnings("unchecked")
    public E peek(){
        return (E) data[size-1];
    }

    @SuppressWarnings("unchecked")
    public E pop() { //取出并移除栈顶元素
        if (size == 0) return null;
        E c = (E) data[--size];
        data[size] = null;
        return c;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}