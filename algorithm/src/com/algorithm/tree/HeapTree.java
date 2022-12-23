package com.algorithm.tree;

import java.util.Arrays;

/**
 * 堆树
 *
 * @author Zijian Liao
 * @since 1.0
 */
public class HeapTree {

    private int[] arr;

    public HeapTree() {
    }

    public HeapTree(int capacity) {
        arr = new int[capacity];
    }

    /**
     * 堆化方法，小顶堆
     *
     * @param start {@code int} 化堆结点
     * @param end   {@code int} 化堆结束点
     */
    public void heapIndex(int start, int end) {
        int parent = start;
        while (parent * 2 + 1 < end) {
            int son = parent * 2 + 1;
            if (son + 1 < end && arr[son + 1] < arr[son]) {
                son = son + 1;
            }
            if (arr[son] < arr[parent]) {
                int temp = arr[son];
                arr[son] = arr[parent];
                arr[parent] = temp;
            }
            parent = son;
        }
    }

    /**
     * 排序
     */
    public void sort() {
        for (int i = arr.length - 1; i > 0; i--) {
            // 将小顶堆的根节点（最小的数）放到最后
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 继续化堆
            heapIndex(0, i);
        }
    }

    /**
     * 创建堆
     *
     * @param arr {@code int[]} 初始堆
     */
    public void createHeap(int[] arr) {
        this.arr = arr;
        int len = arr.length;
        // 从最后一个[非叶子]结点开始
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapIndex(i, len);
        }
    }

    /**
     * top K 问题，找最大的k个数
     *
     * @param number
     */
    public void topK(int number) {
        if (number < arr[0]) {
            return;
        }
        arr[0] = number;
        heapIndex(0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {30, 23, 17, 18, 5, 10, 11};
        HeapTree heapTree = new HeapTree();
        heapTree.createHeap(arr);
        heapTree.sort();
        System.out.println(Arrays.toString(arr));
    }

}
