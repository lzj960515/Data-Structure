package com.algorithm.tree;

import java.util.Arrays;
import java.util.Random;

/**
 * Top K 问题 给你1亿个的数字（整数，1~2^32-1），求出前10大的数字，还可动态添加新数字。
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
