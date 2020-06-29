package com.algorithm.list;

import java.util.Iterator;

/**
 * @author Zijian Liao
 * @date 2020/5/18 22:37
 * @description
 */
public interface MyList<E> extends Iterable<E> {

    int size();

    void add(E e);

    void add(E e,int index);

    void remove(int index);

    void remove(E e);

    E get(int index);

    Iterator<E> iterator();

    int indexOf(E e);
}
