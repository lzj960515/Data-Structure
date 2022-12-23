package com.solution.easy;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
class CQueue {

    private static class Stack<E> { //自定义栈
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

    private Stack<Integer> store = new Stack<>(10000);

    private Stack<Integer> load = new Stack<>(10000);

    public CQueue() {

    }
    
    public void appendTail(int value) {
        store.push(value);
    }
    
    public int deleteHead() {
        if (load.isEmpty()) {
            if(store.isEmpty()){
                return -1;
            }
            while (!store.isEmpty()){
                load.push(store.pop());
            }
        }
        return load.pop();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
