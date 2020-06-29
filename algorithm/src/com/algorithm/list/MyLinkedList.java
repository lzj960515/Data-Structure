package com.algorithm.list;

import java.util.Iterator;

/**
 * @author Zijian Liao
 * @date 2020/5/19 22:57
 * @description 双向链表
 */
public class MyLinkedList<E> implements MyList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(null, e, null);
        if (first == null) {
            first = newNode;
            last = newNode;
            size++;
            return;
        }
        last.next = newNode;
        newNode.pre = last;
        last = newNode;
        size++;
    }

    @Override
    public void add(E e, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node<E> newNode = new Node<>(null, e, null);
        if (index == size) {//加在末尾
            add(e);
            return;
        }
        Node<E> cur = node(index);
        newNode.next = cur;
        if (cur.pre == null) {//头
            cur.pre = newNode;
            first = newNode;
        } else {
            newNode.pre = cur.pre;
            cur.pre.next = newNode;
            cur.pre = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == size) {
            last.pre.next = null;
            last = last.pre;
            size--;
            return;
        }
        Node<E> cur = node(index);
        if (cur.pre == null) {
            cur.next.pre = null;
            first = cur.next;
        } else {
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
        }
        size--;
    }

    private Node<E> node(int index){
        Node<E> cur = null;
        if (index < (size >> 1)) {//插入位置小于链表的一半
            //从前遍历
            cur = first;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }//index=3 插入在第四个位置 cur为第4个链表元素

        } else {
            //从后遍历
            cur = last;
            for (int i = size - 1; i > index; i--) {
                cur = cur.pre;
            }//index=3 插入在第四个位置 cur为第4个链表元素 size =5 last.index=4
        }
        return cur;
    }
    @Override
    public void remove(E e) {
        remove(indexOf(e));
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int indexOf(E e) {
        Node<E> cur = first;
        for (int i = 0 ;i<size;i++){
            if(e.equals(cur.element)){
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    private class Node<E> {
        private E element;
        private Node<E> pre;
        private Node<E> next;

        public Node(Node<E> pre, E element, Node<E> next) {
            this.pre = pre;
            this.element = element;
            this.next = next;
        }
    }
}

