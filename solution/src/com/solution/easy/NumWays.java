package com.solution.easy;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 */
public class NumWays {

    public int numWays(int n) {
        // n=2 11，2
        // n=3 111, 12, 21
        // n=4 1111, 112, 121, 211, 22
        // n=5 11111, 1112, 1121, 1211, 2111, 122, 212, 221
        // f(n) = f(n-1) + f(n-2)
        // 为什么跳4阶等于跳2阶+跳3阶？
        // 跳4阶等于跳到第2阶跳2，也等于跳到第3阶跳1
        // 等于第2阶的m种跳法 + 第3阶的n种跳法
        if(n == 0) return 1;
        if(n == 1) return 1;
        return numWays(n, 1, 1);
    }

    public int numWays(int n, int pre, int res){
        if(res >= 1000000007) res -= 1000000007;
        if(n <= 1) return res;
        return numWays(--n, res, pre + res);
    }

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays(7));
    }
}
