package com.solution.medium;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof
 */
public class MaxValue {

    public int maxValue(int[][] grid) {
        // dp[m][n] = Math.max(dp[m][n-1], dp[m-1][n]) + grid[m][n]
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int m = 1; m < grid.length; m++){
            dp[m][0] = dp[m-1][0] + grid[m][0];
        }
        for (int n = 1; n < grid[0].length; n++){
            dp[0][n] = dp[0][n-1] + grid[0][n];
        }
        for (int m = 1; m < grid.length; m++) {
            for (int n = 1; n < grid[m].length; n++) {
                dp[m][n] = Math.max(dp[m][n-1], dp[m-1][n]) + grid[m][n];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        MaxValue maxValue = new MaxValue();
        System.out.println(maxValue.maxValue(grid));
    }
}
