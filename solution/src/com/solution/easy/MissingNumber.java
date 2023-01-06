package com.solution.easy;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/que-shi-de-shu-zi-lcof
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        // n = 5;
        // 0 ~ 4
        // [0,2,3,4]
        // [0,1,2,3]
        // nums[i] == i
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == mid){
                // 在右边
                left = mid + 1;
            }else {
                // 在左边
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{0,1,3}));
        System.out.println(missingNumber.missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
        System.out.println(missingNumber.missingNumber(new int[]{0,1,2}));
        System.out.println(missingNumber.missingNumber(new int[]{1,2,3}));
    }
}
