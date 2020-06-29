package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author Zijian Liao
 * @date 2020/5/30 14:51
 * @description 插入排序
 */
public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {//默认首位已排好序
            int data = arr[i];
            int j = i;
            while (j > 0) {
                if (data > arr[j - 1]) //要排序的元素与前一位比较
                    break;//大则退出
                arr[j] = arr[j - 1];//小则将前一位元素向后移动 留下一个空位
                j--;
            }
            arr[j] = data;//将排序元素赋值给空位
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 6, 2, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
