package com.solution.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 限制：2 <= n <= 100000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        // 2, 3, 1, 0, 2, 5, 3
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    public int findRepeatNumber4(int[] nums) {
        // bitmap
        int[] result = new int[(nums.length >> 5) + 1];
        for (int num : nums) {
            int index = num >> 5;
            int data = num & 31;
            if((result[index] & (1 << data)) == 0){
                result[index] = result[index] | (1 << data);
            }else {
                return num;
            }
        }
        return 0;
    }

    public int findRepeatNumber3(int[] nums) {
        int[] result = new int[nums.length];
        for (int num : nums) {
            if(result[num] == 0){
                result[num] = 1;
            }else {
                return num;
            }
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.add(num)){
                return num;
            }
        }
        return 0;
    }

    public int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i+1; i1 < nums.length; i1++) {
                if(nums[i] == nums[i1]){
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        System.out.println(findRepeatNumber.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
