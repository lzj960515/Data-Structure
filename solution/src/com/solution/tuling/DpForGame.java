package com.solution.tuling;

/**
 * @author Zijian Liao
 * @since 1.0.0
 */
public class DpForGame {

    public static int dp(int[] value, int[] size, int bagSize){
        // 三个物品，价值和占格分别为
        // 1. 1500 | 1
        // 2. 2000 | 3
        // 3. 3000 | 4
        // 背包格子：bagSize
        // 求能放入背包的最大价值
        // 当为物品i，背包n时的最大价值
        int[][] dp = new int[value.length+1][bagSize+1];
        for (int i = 1; i <= value.length; i++) {
            // 遍历背包的格子，计算当格子大小为n时的最大价值
            for (int n = 1; n <= bagSize; n++) {
                // 当前物品所占格子数
                int m = size[i-1];
                if(m <= n){
                    // 放得下
                    // f(i,n) = Math.max(i_value + f(n-m), f(i-1,n))
                    dp[i][n] = Math.max(value[i-1] + dp[i-1][n-m], dp[i-1][n]);
                }else {
                    // f(i,n) = f(i-1,n)
                    dp[i][n] = dp[i-1][n];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(dp(new int[]{1500, 2000, 3000}, new int[]{1,3,4}, 4));
        System.out.println(dp(new int[]{1500, 2000, 3000}, new int[]{1,3,4}, 5));
        System.out.println(dp(new int[]{10, 20, 50}, new int[]{1,2,4}, 5));
        System.out.println(dp(new int[]{6, 10, 12}, new int[]{1,2,4}, 5));
    }

    public int balancedStringSplit(String s) {
        int count = 0;
        int cur = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(c == 'R'){
                cur++;
            }else {
                cur--;
            }
            if(cur == 0){
                count++;
            }
        }
        return count;
    }
}
