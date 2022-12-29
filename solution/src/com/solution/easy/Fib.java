package com.solution.easy;

import java.util.Map;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 * 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Fib {

    public int fib(int n) {
        if(n==0) return 0;
        return fib(n, 1, 1);
    }

    public int fib(int n,int pre,int res){
        if(res>1000000007) res -= 1000000007;
        if(n<=2) return res;
        return fib(n-1, res, pre + res);
    }

    public int fib2(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] values = new int[n];
        return (fib2(n -1, values) + fib2(n -2 ,values));
    }

    public int fib2(int n, int[] values) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(values[n] != 0){
            return values[n];
        }
        int value = fib2(n - 1, values) + fib2(n - 2, values);
        values[n] = value % 1000000007;
        return values[n];
    }

    public int fib1(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return (fib1(n - 1) + fib1(n - 2)) % 1000000007;
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(8));
    }
}
