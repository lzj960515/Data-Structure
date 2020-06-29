package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author Zijian Liao
 * @date 2020/5/30 16:17
 * @description 选择排序
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        //在数组中选择一个最小的数，与最前面的数进行交换
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int loc = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[loc]) {
                    loc = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[loc];
            arr[loc] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 8, 3, 6, 2, 9 , 5 , 11 , 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
