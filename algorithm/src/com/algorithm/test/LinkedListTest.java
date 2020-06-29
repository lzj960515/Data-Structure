package com.algorithm.test;

import com.algorithm.list.MyLinkedList;
import com.algorithm.list.MyList;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zijian Liao
 * @date 2020/5/19 23:41
 * @description
 */
public class LinkedListTest {
    public static void main(String[] args) {
//        List<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.remove(1);
//        linkedList.remove(new Integer(1));
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.remove(new Integer(3));
        linkedList.add(7,0);
        linkedList.add(9,4);
        for(int i =0;i<linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }

    }
}
