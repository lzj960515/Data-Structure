package com.algorithm.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Zijian Liao
 * @date 2020/5/18 16:09
 * @description
 */
public class MyArrayList<E> implements MyList<E> {

    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity == 0) {
            data = new Object[DEFAULT_CAPACITY];
        } else {
            data = new Object[initialCapacity];
        }
    }
    @Override
    public void add(E element) {
        ensureAdd();    //判断是否即将越界，扩容
        data[size++] = element;
    }

    @Override
    public void add(E element, int index) { //6  3 size = 5
        ensureAdd();
        // 1 2 3 4 5  -> 1 2 3 6 4 5
        int srcPost = index;
        int destPost = index + 1;
        int length = size - index;
        System.arraycopy(data, srcPost, data, destPost, length);
        data[index] = element;
        size++;
    }

    private void ensureAdd(){
        if (size + 1 > data.length) {
            int newCapacity = data.length * 2;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor;       // index of next element to return
            @Override
            public boolean hasNext() {
                return cursor != size;
            }
            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                if (cursor >= size)
                    throw new NoSuchElementException();
                Object[] elementData = MyArrayList.this.data;
                if (cursor >= elementData.length)
                    throw new ConcurrentModificationException();
                return (E) elementData[cursor++];
            }
        };
    }

    @Override
    public void remove(int index) { // index = 2 size = 5
        //1 2 3 4 5  -> 1 2 4 5
        int srcPost = index + 1;
        int destPost = index;
        int length = size - index - 1; //2
        System.arraycopy(data, srcPost, data, destPost, length);
        data[--size] = null;
    }

    @Override
    public void remove(E element) { // 3 size=5
        //1 2 3 4 5 -> //1 2 4 5
        for (int i = 0; i < size; i++) {
            if (element == data[i]) {
                remove(i);
            }
        }
    }
    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element == data[i]) return i;
        }
        return -1;
    }
    @Override
    public int size() {
        return size;
    }

}
