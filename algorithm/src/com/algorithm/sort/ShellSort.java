package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author Zijian Liao
 * @date 2020/5/30 15:15
 * @description 希尔排序
 */
public class ShellSort {

    public static void sort(int[] arr) {
        //将元素分组再进行插入排序
        //4, 8, 3, 6, 2, 9 , 5 , 11 , 1
        //n/2=4 步长为4 分为4 2 1| 8 9 | 3 5 | 6 11
        //排序后 1 2 4 | 8 9 | 3 5 | 6 11
        //n/2/2=2 步长为2  1 4 9 5 11|2 8 3 6
        //排序 1 4 5 9 11|2 3 6 8
        //n/2/2/2=1 步长为1 排序后-> 1 2 3 4 5 6 8 9 11

        //最外层为步长循环
        int n = arr.length;
        for (int i = n / 2; i > 0; i = i / 2) { //每次循环步长缩小一半
            for (int j = i; j < n; j++) { //从n/2开始，默认前部分（每个分组的首位）已排好序
                int k = j;
                int data = arr[j];
                while (k >= i) {
                    if (data > arr[k - i])
                        break;
                    arr[k] = arr[k - i];
                    k = k - i;
                }
                arr[k] = data;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 3, 6, 2, 9 , 5 , 11 , 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
