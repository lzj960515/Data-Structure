package com.solution.tuling;

/**
 * @author Zijian Liao
 * @since 1.0.0
 */
public class DpForGame {

    public int dpForGame(int[] value, int[] size, int bagSize){
        // 三个物品，价值和占格分别为
        // 1. 1500 | 1
        // 2. 2000 | 3
        // 3. 3000 | 4
        // 背包剩余格子：n
        // 求能放入背包的最大价值
        // 设 f(i) 为背包占格子数为i时的最大价值
        // 当放入一个占格子数为m物品时
        // f(m) = Math.max(m_value + f(n-m), f(m))
        int[] dp = new int[bagSize+1];
        for (int i = 0; i < value.length; i++) {
            // 遍历背包的格子，计算当格子大小为j时的最大价值
            for (int j = 1; j <= bagSize; j++) {
                // 当前物品所占格子数
                int curSize = size[i];
                if(curSize <= j){
                    // 放得下
                    // f(j) = Math.max(i_value + f(bagSize-curSize), f(j))
                    dp[j] = Math.max(value[i] + dp[bagSize-curSize], dp[j]);
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        DpForGame dpForGame = new DpForGame();
        System.out.println(dpForGame.dpForGame(new int[]{1500, 2000, 3000}, new int[]{1,3,4}, 4));
        System.out.println(dpForGame.dpForGame(new int[]{2000, 2000, 5000}, new int[]{1,3,4}, 4));
        System.out.println(dpForGame.dpForGame(new int[]{10, 20, 50}, new int[]{1,2,4}, 5));
    }
}
