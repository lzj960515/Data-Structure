package com.solution.easy;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 示例 1：
 *
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：numbers = [2,2,2,2,0,1]
 * 输出：0
 *
 * 提示：
 *
 * n == numbers.length
 * 1 <= n <= 5000
 * -5000 <= numbers[i] <= 5000
 * numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 */
public class MinArray {

    public int minArray(int[] numbers){
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int mid = left + (right - left) /2;
            if(numbers[mid] < numbers[right]){
                right = mid;
            }else if(numbers[mid] > numbers[right]) {
                left = mid + 1;
            }else {
                // 说明相等，这时候不晓得最小值在哪边，尝试缩小left和right的间距
                right--;
            }
        }
        return numbers[left];
    }

    public int minArray2(int[] numbers) {
        // 第一个数比最后一个数大 -> 第一个数比后面序列的任何数都大
        // 找到比第一个数小的数 -> 二分 -> 如果中间数比第一个数小，则说明中间数是被旋转的其中一个数，最小数在左边
        // 如果中间数比第一个数大，说明最小数在右边
        // 重复步骤，直到二分结束, 最左边的树即为最小数
        int first = numbers[0];
        // 居然还有一个数字的测试用例，纯纯恶心人
        if(numbers.length == 1){
            return first;
        }
        // 如果第一个数比最后一个数小，说明没有反转，这个逻辑我都觉得好傻逼，命名题干都说了进行了1至n次旋转，tmd还有这种[1,3,5]的测试用例
        if(first < numbers[numbers.length-1]){
            return first;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right){
            int mid = left + (right - left) /2;
            if(numbers[mid] < first){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if(left == numbers.length){
            // 跑到最右边都没找到，尝试兜底
            int min = first;
            for (int i = 1; i < numbers.length ; i++) {
                if(numbers[i] < min){
                    min = numbers[i];
                }
            }
            return min;
        }

        return numbers[left];
    }

    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        System.out.println(minArray.minArray(new int[]{1,2,2,2,0,1,1}));
        System.out.println(minArray.minArray(new int[]{10,1,10,10,10}));
        System.out.println(minArray.minArray(new int[]{10,10,10,1,10}));
        System.out.println(minArray.minArray(new int[]{1,1}));
        System.out.println(minArray.minArray(new int[]{1,3,5}));
        System.out.println(minArray.minArray(new int[]{3,1,3}));
        System.out.println(minArray.minArray(new int[]{3,4,5,1,2}));
        System.out.println(minArray.minArray(new int[]{2,2,2,2,0,1}));
    }
}
