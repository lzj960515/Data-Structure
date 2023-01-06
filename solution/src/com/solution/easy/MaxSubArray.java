package com.solution.easy;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        // 如果dp[i-1]是个正数，说明他还有机会加出一个最大值，可以继续使用
        // 如果dp[i-1]是个负数，说明他已经没有机会加出最大值了，应当舍弃
        for (int i = 1; i < nums.length; i++) {
            // dp[i-1] + nums[i] > nums[i] 说明dp[i-1]是个正数
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        if(nums.length == 1){
            return nums[0];
        }
        // 从头开始加，记录最大的和，最小的和
        // 最小的和不是第一位，而是0
        int min = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            // 当前和
            sum += num;
            // 当前和 - 前面最小和 和 答案比较哪个大
            ans = Math.max(ans, sum - min);
            // 记录最小的和
            min = Math.min(min, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, -1}));
        System.out.println(maxSubArray.maxSubArray(new int[]{1, 2}));
        System.out.println(maxSubArray.maxSubArray(new int[]{-1,0,-2}));
        System.out.println(maxSubArray.maxSubArray(new int[]{1,-1,-2}));
    }
}
