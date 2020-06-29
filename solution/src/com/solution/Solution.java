package com.solution;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zijian Liao
 * @date 2020/5/19 15:09
 * @description
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //nums1  1 4 6
        //nums2  2 3 7
        int[] sort = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, sort, 0, nums1.length);
        System.arraycopy(nums2, 0, sort, nums1.length, nums2.length);
        Arrays.sort(sort);
        if (sort.length % 2 == 0) {
            int mid1 = sort.length / 2 - 1;  // 1 2 3 4  2 3 12
            int mid2 = sort.length / 2;
            return (sort[mid1] + sort[mid2]) / 2.0;
        } else {
            return sort[sort.length / 2]; //123 1.5
        }
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if(nums1.length==0){
            return nums2.length%2==0?(nums2[nums2.length/2-1]+nums2[nums2.length/2])/2.00:nums2[nums2.length/2];
        }
        if(nums2.length==0){
            return nums1.length%2==0?(nums1[nums1.length/2-1]+nums1[nums1.length/2])/2.00:nums1[nums1.length/2];
        }

        //nums1  1 4 6 10 15
        //nums2  21 31 71 121 301

        //nums1  1 4 6 10 15
        //nums2  12 14 71 121 301
        //并行查找
        //取出第一组 和 第二组的第一个元素 相互比较
        //留下大的元素，舍去小的元素，记录次数cursor,再去小的元素的数组中取元素
        //若cursor小于两组元素之和的一半 重复以上步骤
        //结果计算 两数组长度为偶数：小元素 与 min(小元素所在数组的下一个元素,当前大元素）相加除2
        //两数组长度为奇数：min(小元素,大元素）
        int totalLength = nums1.length + nums2.length; //8
        boolean even = totalLength % 2 == 0;
        int midLength =  totalLength / 2; //3
        int cursor = 0;
        int i = 0;
        int j = 0;
        int max = 0;
        int min = 0;
        int next = 0;
        int num1 = nums1[i++];
        int num2 = nums2[j++];


        while (cursor < midLength) {
            if (num1 > num2) {
                if(j == nums2.length){
                    //该数组已查找完 元素在nums1中  1 2 3 4

                    int index = midLength - nums2.length;
                    if(even){
                        if(nums2.length == midLength){
                            return (nums2[nums2.length -1] + nums1[0])/2.00;
                        }
                        if(cursor + 1 == midLength){
                            return (Math.max(nums2[j-1],nums1[index-1])+nums1[index])/2.00;
                        }
                        return (nums1[index-1] + nums1[index])/2.00;
                    }else{
                        return nums1[index];
                    }
                }
                max = num1;
                min = num2;
                num2 = nums2[j++];
                next = num2;
            } else {
                if(i == nums1.length){
                    //该数组已查找完 元素在nums2中
                    int index = midLength - nums1.length;
                    if(even){
                        if(nums1.length == midLength){
                            return (nums1[nums1.length -1] + nums2[0])/2.00;
                        }
                        if(cursor + 1 == midLength){
                            return (Math.max(nums1[i-1],nums2[index-1])+nums2[index])/2.00;
                        }
                        return (nums2[index-1] + nums2[index])/2.00;
                    }else{
                        return nums2[index];
                    }
                }
                max = num2;
                min = num1;
                num1 = nums1[i++];
                next = num1;
            }
            cursor++;
        } //cursor = 3
        if(even){
            return  (min + Math.min(max,next))/2.0;
        }else{
            return Math.min(max,next);
        }
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    //i: nums1的起始位置 j: nums2的起始位置
    public static int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }
    }
}
