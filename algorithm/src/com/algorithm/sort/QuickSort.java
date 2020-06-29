package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author Zijian Liao
 * @date 2020/5/30 17:23
 * @description 快速排序
 */
public class QuickSort {

    public static void sort(int[] arr) {
        //首先确认一个基数 比这个数大的放在这个数后面 比这个数小的放在这个数前面
        //4, 8, 3, 6, 2, 9 , 5 , 11 , 1
        //取第一个基数为4
        //从后面找比他小的数交换 -》 1, 8, 3, 6, 2, 9 , 5 , 11 , 4
        //从前面找比他大的数交换 -》 1, 4, 3, 6, 2, 9 , 5 , 11 , 8
        //从后面找比他小的数交换 -》 1, 2, 3, 6, 4, 9 , 5 , 11 , 8
        //从前面找比他大的数交换 -》 1, 2, 3, 4, 6, 9 , 5 , 11 , 8
        //再以两边分好的组作为新的数组重复以上操作，直到组内元素个数为1
        quickSort(0, arr.length - 1, arr);
    }

    public static void quickSort(int left, int right, int[] arr) {
        if (left >= right) return;
        int loc = left;
        int base = arr[loc];
        int i = left + 1; //双指针
        int j = right;
        while (i < j) {
            while (j > i) {
                if (arr[j] < base) {
                    arr[loc] = arr[j];
                    arr[j] = base;
                    loc = j;
                    break;
                }
                j--;
            }
            while (i < j) {
                if (arr[i] > base) {
                    arr[loc] = arr[i];
                    arr[i] = base;
                    loc = i;
                    break;
                }
                i++;
            }
        }
        quickSort(left, loc - 1, arr);
        quickSort(loc + 1, right, arr);
    }
    public static void main(String[] args) {
        int[] arr = {4, 8, 3, 6, 2, 9 , 5 , 11 , 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
