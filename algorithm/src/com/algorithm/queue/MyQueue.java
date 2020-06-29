package com.algorithm.queue;

/**
 * @author Zijian Liao
 * @date 2020/5/28 22:35
 * @description 循环队列
 */
public class MyQueue<E> {

    private Object[] data;

    private int head;

    private int tail;

    private int capacity; //队列容量

    private static int DEFAULT_CAPACITY = 10;

    public MyQueue(){
        this(DEFAULT_CAPACITY);
    }


    public MyQueue(int capacity){
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public void push(E e){
        if(tail - head == capacity) throw new IndexOutOfBoundsException("队列已满");
        data[tail++%capacity] = e;
    }

    @SuppressWarnings("unchecked")
    public E pop(){
        if(tail == head) return null;
        if(head >= capacity){
            head -= capacity;
            tail -= capacity;
        }
        Object e = data[head];
        data[head++] = null;
        return (E) e;
    }

    public int size(){
        return tail - head;
    }

    public boolean isEmpty(){
        return tail == head;
    }
}
