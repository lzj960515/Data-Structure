package com.solution.easy;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 */
public class Search {

    public int search(int[] nums, int target) {
        if(nums.length == 0) return 0;
        // 二分
        int index = findIndex(nums, target);
        if (index == -1) {
            return 0;
        }
        int tmp = index;
        while (++index < nums.length && nums[index] == target){
        }

        while (--tmp >= 0 && nums[tmp] == target){
        }

        return index - tmp - 1;
    }

    private int findIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            //在二分查找中，我们通常使用 left + (right - left) / 2 来计算中间位置的下标，而不是使用 (left + right) / 2。
            //这是因为，当 left 和 right 非常大时，两者的和可能会超出整数的表示范围，导致溢出。
            // 例如，如果 left 等于 2147483647（最大的整数值），
            // 而 right 等于 2147483646，那么 left + right 就会发生溢出，
            // 得到的结果是 -2147483649，而不是正确的 4294 967293。
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{2,2}, 3));
        System.out.println(search.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(search.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}
