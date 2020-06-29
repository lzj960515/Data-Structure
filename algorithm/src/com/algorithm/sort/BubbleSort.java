package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author Zijian Liao
 * @date 2020/5/30 17:19
 * @description 冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 8, 3, 6, 2, 9 , 5 , 11 , 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
