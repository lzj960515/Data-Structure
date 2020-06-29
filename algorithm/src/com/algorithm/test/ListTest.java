package com.algorithm.test;

import com.algorithm.list.MyArrayList;
import com.algorithm.list.MyList;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zijian Liao
 * @date 2020/5/18 22:24
 * @description
 */
public class ListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4", 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println("size =>"+list.size());
        System.out.println("3 index => "+list.indexOf("3"));
        list.remove("1");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.remove(1);
        linkedList.remove(new Integer(1));
    }
}
