package com.algorithm.test;

import com.algorithm.queue.MyQueue;

/**
 * @author Zijian Liao
 * @date 2020/5/30 13:12
 * @description
 */
public class QueueTest {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

//        while (!queue.isEmpty()){
//            System.out.println(queue.pop());
//        }
//        System.out.println("===================");
        queue.push(6);
        queue.push(7);
        queue.push(8);
        queue.push(9);
        queue.push(10);
//        while (!queue.isEmpty()){
//            System.out.println(queue.pop());
//        }
        queue.pop();
        System.out.println("===================");
        queue.push(11);
        queue.pop();
        queue.push(12);
        queue.pop();
        queue.push(13);
        queue.pop();
        queue.push(14);
        while (!queue.isEmpty()){
            System.out.println(queue.pop());
        }
    }
}
