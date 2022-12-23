package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author Zijian Liao
 * @date 2020/5/30 15:49
 * @description 归并排序
 */
public class MergeSort {

    public static void sort(int[] arr) {
        //先进行拆分，再进行合并
        split(0, arr.length - 1, arr);
    }

    public static void split(int left, int right, int[] arr) {
        if (left == right){
            return;
        }
        int mid = (left + right) / 2;//拆分的中间值
        split(left, mid, arr);
        split(mid + 1, right, arr);
        //合
        merge(left, mid, right, arr);
    }

    public static void merge(int left, int mid, int right, int[] arr) {
        int[] temp = new int[right + 1 - left];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
    public static void main(String[] args) {
        int[] arr = {4, 8, 3, 6, 2, 9 , 5 , 11 , 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
