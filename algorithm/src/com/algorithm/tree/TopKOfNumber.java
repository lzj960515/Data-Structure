package com.algorithm.tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * Top K 问题
 *
 * @author Zijian Liao
 * @since 1.0
 */
public class TopKOfNumber {

    public static void main(String[] args) {
        HeapTree heapTree = new HeapTree(10);
        long startTime = System.currentTimeMillis();
        final Random random = new Random();
        int[] arr = new int[10];
        //初始化堆
        for (int i = 0; i < 10; i++) {
            arr[i] = Math.abs(random.nextInt());
        }
        heapTree.createHeap(arr);
        for (int i = 0; i < 100000000; i++) {
            int number = random.nextInt();
            heapTree.topK(number);
        }
        heapTree.topK(Integer.MAX_VALUE);
        System.out.println(Arrays.toString(arr));
        System.out.println("共花费时间: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
